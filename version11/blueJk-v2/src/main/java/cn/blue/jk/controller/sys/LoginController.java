package cn.blue.jk.controller.sys;

import cn.blue.common.other.UserSession;
import cn.blue.common.view.VIEW;
import cn.blue.jk.domain.User;
import cn.blue.jk.exception.ControllerException;
import cn.blue.jk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController extends AuthenticationException {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;


    /**
     * 传统登录
     *
     * @param username
     * @param password
     * @param map
     * @return
     * @throws Exception
     */
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Map<String, Object> map) throws ControllerException,Exception {
        String path = "";
        if (username != null && username.length() > 0 && password != null && password.length() > 0) {
            User user = userService.getPassword(username);
            if (user != null) {
                if (password.equals(user.getPassword())) {
                    path = "redirect:/fmain.action";
                } else {//密码错误
                    path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
                    map.put("loginFailed", "密码错误");
                }
            } else {//用户名错误
                path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
                map.put("loginFailed", "用户名错误");
            }
        } else {//输入非法
            path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
            map.put("loginFailed", "输入非法");
        }
        logger.info(path);
        logger.info("" + map);
        return path;
    }

    /**
     * shiro 登录
     *
     * @param username
     * @param password
     * @param map
     * @return
     */
    @RequestMapping(value = "/sys/login.action")
    public String loginShiro(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,@RequestParam(value = "rememberMe",defaultValue = "0")Integer rememberMe, Map<String, Object> map) throws ControllerException{
        String path = "";
        if (username != null && username.length() > 0 && password != null && password.length() > 0) {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            /**remBer Me*/
            if (rememberMe!=null){
                if (rememberMe==1) token.setRememberMe(true);
            }
            try {
                System.out.println(username+" "+password);
                User user = userService.getPassword(username);
                subject.login(token);
                logger.info("登录成功!");
                subject.getSession().setAttribute(UserSession.USER_SESSION.getVar(),user);//加入到会话中
                path = "redirect:/fmain.action";
            } catch (AuthenticationException e) {
                logger.info("exception:"+e.getMessage());
                path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
                map.put("loginFailed", "用户名或者密码错误");
            } catch (Exception e) {
                logger.info("exception:"+e.getMessage());
                path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
                map.put("loginFailed", "用户名错误");
            }
        } else {
            path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
            map.put("loginFailed", "输入非法");
        }
        return path;
    }

    @RequestMapping(value = "/sys/logout.action")
    public String logout()throws ControllerException{
        String path = "";
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        if (subject.getSession().getAttribute(UserSession.USER_SESSION.getVar())!=null)subject.getSession().removeAttribute(UserSession.USER_SESSION.getVar());
        path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
        logger.info("/sys/logout.action");
        return path;
    }

}
