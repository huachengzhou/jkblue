package me.spring;

import cn.blue.jk.domain.Role;
import cn.blue.jk.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

public class RoleServiceTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RoleService roleService = null;
    private String[] ids = null;

    @Test
    public void find() throws Exception {
        List<Role> roles = roleService.find(null);
        roles.forEach((role -> {
            logger.info(role + "");
            role.getPrivileges().forEach((privilege -> logger.info(privilege + "")));
        }));
    }

    @Test
    public void insert() throws Exception {
        Role role = new Role();
        String id = UUID.randomUUID().toString();
        role.setRid(id);
        role.setDescription("学校");
        role.setRole_name("school");
        role.setAvailable(false);
        roleService.insert(role, ids);
        role = roleService.get(id);
        logger.info(role + "");
    }

    @Test
    public void update() throws Exception {
        String id = "4401e86f-f69f-4fa2-86dc-4e85d5a3bb07";
        Role role = roleService.get(id);
        role.setDescription("学校x");
        roleService.update(role,ids);
    }

    @Test
    public void delete() throws Exception {
        String id = "26dfb027-ad79-4b9a-b090-4c8898abded7";
        roleService.delete(id);
    }

    @Before
    public void init() throws Exception {
        roleService = context.getBean(RoleService.class);
        logger.info(roleService + "");
        ids = new String[]{"612d7f7e-62b7-4364-854d-ac115473275e", "3070827e-8cc8-4cd7-a43a-0a5ac3b431d2"};
    }

}
