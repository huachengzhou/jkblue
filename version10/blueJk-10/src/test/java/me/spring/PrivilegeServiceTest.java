package me.spring;

import cn.blue.jk.domain.Privilege;
import cn.blue.jk.service.PrivilegeService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

public class PrivilegeServiceTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private PrivilegeService privilegeService = null;

    @Test
    public void insert() throws Exception {
        Privilege privilege = new Privilege();
        privilege.setPid(UUID.randomUUID().toString());
        privilege.setDescription("普通用户:查看");
        privilege.setPrivilege_name("user:select");
        privilegeService.insert(privilege);
        logger.info(privilege + "");
    }

    @Test
    public void get() throws Exception {
        String pid = "44eb7c95-f432-472d-811b-f6034bef4f78";
        Privilege privilege = privilegeService.get(pid);
        logger.info(privilege + "");
    }

    @Test
    public void delete() throws Exception {
        String id = "44eb7c95-f432-472d-811b-f6034bef4f78";
        privilegeService.delete(id);
    }

    @Test
    public void find() throws Exception {
        List<Privilege> privileges = privilegeService.find(null);
        privileges.stream().forEach((privilege -> logger.info(privilege + "")));
    }

    @Test
    public void update() throws Exception {
        String pid = "44eb7c95-f432-472d-811b-f6034bef4f78";
        Privilege privilege = privilegeService.get(pid);
        privilege.setPrivilege_name("user:delete");
        System.out.println(privilege);
        privilegeService.update(privilege);
    }

    @Before
    public void init() throws Exception {
        privilegeService = (PrivilegeService) context.getBean("privilegeService");
    }
}
