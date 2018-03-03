package cn.blue.jk.controller.sys;

import cn.blue.common.view.VIEW;
import cn.blue.jk.domain.Privilege;
import cn.blue.jk.domain.Role;
import cn.blue.jk.exception.ControllerException;
import cn.blue.jk.service.PrivilegeService;
import cn.blue.jk.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping(value = "/sys")
@Controller
public class RoleController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;

    @RequestMapping(value = "/listRole.action")
    public String list(Map<String, Object> map) throws ControllerException,Exception {
        List<Role> roles = roleService.find(null);
        map.put("datalist", roles);
        System.out.println(roles);
        return VIEW.Pages.getVar() + "sys/role/listRole" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/toCreateRole.action")
    public String toAddView(Map<String, Object> map) throws ControllerException,Exception {
        logger.info("/sys/toCreateRole.action");
        List<Privilege> privileges = privilegeService.find(null);
        map.put("privileges", privileges);
        return VIEW.Pages.getVar() + "sys/role/toCreateRole" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/toAddRole.action")
    public String toAddRole(Role role, @RequestParam(value = "pid") String pid) throws ControllerException,Exception {
        String[] ids = pid.split(",");
        String description = URLDecoder.decode(role.getDescription(), "UTF-8");
        role.setDescription(description);
        role.setRid(UUID.randomUUID().toString());
        logger.info(role + "");
        roleService.insert(role, ids);
        return "redirect:/sys/listRole.action";
    }

    @RequestMapping(value = "/removeRole.action")
    public String removeRole(@RequestParam(value = "rid") String rid) throws ControllerException,Exception {
        String[] ids = rid.split(",");
        roleService.delete(ids);
        logger.info("" + rid);
        return "redirect:/sys/listRole.action";
    }

}
