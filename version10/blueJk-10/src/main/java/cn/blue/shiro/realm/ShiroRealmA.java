package cn.blue.shiro.realm;

import cn.blue.common.help.ZhouBase64;
import cn.blue.jk.domain.Privilege;
import cn.blue.jk.domain.Role;
import cn.blue.jk.domain.User;
import cn.blue.jk.service.RoleService;
import cn.blue.jk.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealmA extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();
        System.out.println(userService);
        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        User user = null;
        try {
            user = userService.login(username);
            //终于知道原因了,原来这查出来的user的密码并非完全是查出来的数据,这的用户密码已经是解密之后的密码了
            //因此下面的废弃
//            user = toUser(user);
            if (user == null) throw new UnknownAccountException("用户不存在!");
        } catch (Exception e) {
            e.printStackTrace();
        }


        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;
        //2). credentials: 密码.
        Object credentials = null; //
        credentials = user.getPassword();
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();
        //4). 盐值.
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUid());
        SimpleAuthenticationInfo info = null;
//        info = new SimpleAuthenticationInfo(principal, credentials, realmName);//简单
        info = new SimpleAuthenticationInfo(principal, credentials,credentialsSalt ,realmName);//稍微复杂点
        return info;
    }


    /**
     * 授权会被 shiro 回调的方法
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1. 从 PrincipalCollection 中来获取登录用户的信息
        Object principal = principals.getPrimaryPrincipal();

        //2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
        User user = null;
        try {
            user = userService.getPassword((String) principal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3. 创建 SimpleAuthorizationInfo, 并设置其 roles 属性.
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(resolt(user));
        //继续添加　权限信息
        Set<String> permissions = this.getPermissions(user);
        info.setStringPermissions(permissions);
        // 其实　角色信息　也可以这样子做
        //4. 返回 SimpleAuthorizationInfo 对象.
        return info;
    }

    /**
     * md5 加密　暂时不用
     *
     * @param password
     * @param username
     * @return
     */
    public String getResolt(String password, String username) {
        String hashAlgorithmName = "MD5";
        Object credentials = password;
        Object salt = ByteSource.Util.bytes(username);
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
        return (String) result;
    }

    /**
     * 角色遍历
     *
     * @param user
     * @return
     */
    public Set<String> resolt(User user) {
        Set<String> stringSet = new HashSet<>();
        user.getRoles().forEach((role -> {
            stringSet.add(role.getRole_name());
        }));
        System.out.println(stringSet);
        return stringSet;
    }

    public Set<String> getPermissions(User user) {
        Set<String> set = new HashSet<>();

        user.getRoles().forEach((role -> {
            try {
                Role r = roleService.get(role.getRid());
                Set<Privilege> privileges = r.getPrivileges();
                privileges.forEach((privilege -> {
                    set.add(privilege.getPrivilege_name());
                }));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }));
        return set;
    }

    /**
     * 方法废弃
     *
     * @param user
     * @return
     */
    public User toUser(User user) {
        String id = user.getUid();
        String password = user.getPassword();
        password = ZhouBase64.isDecode(password);
        int index = id.length();
        password = password.substring(index, password.length());
        user.setPassword(password);
        return user;
    }
}
