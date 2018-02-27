package cn.blue.shiro.realm;

import cn.blue.common.help.ZhouBase64;
import cn.blue.common.other.CredentialEnum;
import cn.blue.jk.domain.Privilege;
import cn.blue.jk.domain.Role;
import cn.blue.jk.domain.User;
import cn.blue.jk.service.RoleService;
import cn.blue.jk.service.UserService;
import cn.blue.shiro.other.MySimpleByteSource;
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
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ShiroRealmA extends AuthorizingRealm implements Serializable {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private UserService userService;

    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private RoleService roleService;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("进入ShiroRealmA");
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();
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
        Object credentials = user.getPassword();//简单密码
        RealmUtil realmUtil = new RealmUtil(userService, roleService);
        credentials = realmUtil.getPassword(user.getPassword(), user.getUid(), CredentialEnum.SHA1);// 复杂密码 在使用之前必须在xml中配置
        //假如在添加用户的时候就把这个密码存入帐号信息里面就不用这样麻烦了,由于我们的密码是自己通过base64编码过的
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();

        //4). 盐值.
        MySimpleByteSource byteSourceSalt = new MySimpleByteSource(user.getUid());//序列化的盐值
        SimpleAuthenticationInfo info = null;
//        info = new SimpleAuthenticationInfo(principal, credentials, realmName);//简单
        info = new SimpleAuthenticationInfo(principal, credentials, byteSourceSalt, realmName);//稍微复杂点
        logger.info(info + "");
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
        RealmUtil realmUtil = new RealmUtil(userService, roleService);
        //1. 从 PrincipalCollection 中来获取登录用户的信息
        Object principal = principals.getPrimaryPrincipal();

        //2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
        User user = null;
        try {
            user = userService.getPassword((String) principal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3. 创建 SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //添加 roles 属性.
        Set<String> roles = realmUtil.resolt(user);
        info.setRoles(roles);
        //继续添加　权限信息
        Set<String> permissions = realmUtil.getPermissions(user);
        info.setStringPermissions(permissions);
        logger.info(info + "");
        return info;
    }


}
