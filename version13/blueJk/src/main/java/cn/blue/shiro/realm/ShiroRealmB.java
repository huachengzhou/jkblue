package cn.blue.shiro.realm;

import cn.blue.common.other.CredentialEnum;
import cn.blue.jk.domain.User;
import cn.blue.jk.service.UserService;
import cn.blue.shiro.other.MySimpleByteSource;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;

public class ShiroRealmB extends AuthenticatingRealm implements Serializable{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Lazy //延迟加载
    @Autowired(required = true)//必须注入
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        RealmUtil realmUtil = new RealmUtil();
        logger.info("进入ShiroRealmB");
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();

        //3从数据库查出账户信息
        User user = null;
        try {
            user = userService.login(username);
            if (user == null) throw new UnknownAccountException("用户不存在!");
        } catch (Exception e) {
            logger.error("异常" + e.getMessage());
        }
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;

        //2). credentials: 密码.
        Object credentials = realmUtil.getPassword(user.getPassword(), user.getUid(), CredentialEnum.MD5);

        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();

        //4). 盐值.
        MySimpleByteSource byteSourceSalt = new MySimpleByteSource(user.getUid());//序列化的盐值

        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo(principal, credentials, byteSourceSalt, realmName);//稍微复杂点
        logger.info(info + "");
        return info;
    }
}
