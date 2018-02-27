package me.mybatis;

import cn.blue.jk.domain.Role;
import cn.blue.jk.mapper.RoleMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class RoleMapperTest {
    private RoleMapper roleMapper = null;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void insert() throws Exception {
        Role role = new Role();
        role.setRid(UUID.randomUUID().toString());
        role.setAvailable(true);
        role.setRole_name("student");
        role.setDescription("学生");
        roleMapper.insert(role);
        logger.info(role + "");
    }

    @Before
    public void init() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        roleMapper = context.getBean(RoleMapper.class);
    }
}
