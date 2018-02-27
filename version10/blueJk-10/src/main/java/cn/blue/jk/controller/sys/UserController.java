package cn.blue.jk.controller.sys;

import cn.blue.common.help.ZhouBase64;
import cn.blue.common.view.VIEW;
import cn.blue.jk.domain.User;
import cn.blue.jk.service.RoleService;
import cn.blue.jk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/sys/listUser.action")
    public String list(Map<String, Object> map) throws Exception {
        map.put("datalist", userService.find(null));
        logger.info("/sys/listUser.action");
        return VIEW.Pages.getVar() + "sys/user/listUser" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/sys/removeUser.action")
    public String removeRole(@RequestParam(value = "uid") String uid) throws Exception {
        Serializable[] ids = uid.split(",");
        userService.delete(ids);
        logger.info("" + uid);
        return "redirect:/sys/listUser.action";
    }

    @RequestMapping(value = "/sys/toCreateUser.action")
    public String toAddView(Map<String, Object> map) throws Exception {
        map.put("roles", roleService.find(null));
        return VIEW.Pages.getVar() + "sys/user/toCreateUser" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/sys/createUser.action")
    public String toAddUser(User user, @RequestParam(value = "rid") String rid) throws Exception {
        user.setSalt(System.currentTimeMillis() + "");
        user.setUid(UUID.randomUUID().toString());
        user.setTime(new Date());
        String organizationid = URLDecoder.decode(user.getOrganizationid(), "UTF-8");
        String name = URLDecoder.decode(user.getName(), "UTF-8");
        String password = isPassword(user.getPassword(), user.getUid());

        user.setOrganizationid(organizationid);
        user.setName(name);
        user.setPassword(password);
        String[] ids = rid.split(",");
        logger.info(user + "" + rid);
        userService.insert(user, ids);
        return "redirect:/sys/listUser.action";
    }

    public String isPassword(String password, String id) {//确保每个人的帐号的密码唯一
        id = ZhouBase64.isEncode(id);
        password = ZhouBase64.isEncode(password);
        password = id + password;
        return password;
    }

    @RequestMapping(value = "/sys/ToUserView.action")
    public String toUserView(@RequestParam(value = "uid",defaultValue = "1") String uid, Map<String, Object> map) {
        User user = userService.login(uid);
        map.put("user", user);
        return VIEW.Pages.getVar() + "sys/user/toUserView" + VIEW.JSP.getVar();
    }

}
