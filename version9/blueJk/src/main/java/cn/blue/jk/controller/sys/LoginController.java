package cn.blue.jk.controller.sys;

import cn.blue.common.view.VIEW;
import cn.blue.jk.domain.User;
import cn.blue.jk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sys/login.action")
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Map<String,Object> map) throws Exception {
        String path = "";
        if (username != null && username.length() > 0 && password != null && password.length() > 0) {
            User user = userService.getPassword(username);
            if (user != null) {
                if (password.equals(user.getPassword())) {
                    path = "redirect:/fmain.action";
                } else {//密码错误
                    path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
                    map.put("loginFailed","密码错误");
                }
            } else {//用户名错误
                path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
                map.put("loginFailed","用户名错误");
            }
        } else {//输入非法
            path = VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
            map.put("loginFailed","输入非法");
        }
        logger.info(path);
        logger.info(""+map);
        return path;
    }

}
