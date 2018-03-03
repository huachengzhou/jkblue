package me.spring;

import cn.blue.common.help.ZhouBase64;
import cn.blue.jk.domain.User;
import cn.blue.jk.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserServiceTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserService userService = null;
    private String[] ids = null;

    @Test
    public void insert() throws Exception {
        User user = new User();
        String id = UUID.randomUUID().toString();
        user.setUid(id);
        user.setLock_User(false);
        user.setName("张三");
        user.setUsername("zhangsan");
        user.setOrganizationid("中石油");
        user.setPassword("123456");
        user.setTime(new Date());
        user.setSalt(System.currentTimeMillis() + "");
        userService.insert(user, ids);
    }

    @Test
    public void login() throws Exception {
        User user = userService.login( "admin");
        logger.info("" + user);
        user = userService.getPassword("admin");
        logger.info(""+user);
    }

    @Test
    public void update() throws Exception {
        String id = "7a5edf54-812e-4b69-8f17-927896c47f37";
        User user = userService.get(id);
        logger.info(user + "");
        user.setName("张三２");
        userService.update(user, ids);
    }

    @Test
    public void get() throws Exception {
        String id = "a2fdae92-b2b1-4fce-a288-0b4e138c604e";
        User user = userService.get(id);
        logger.info(user + "");
    }

    @Test
    public void delete() throws Exception {
        String id = "a2fdae92-b2b1-4fce-a288-0b4e138c604e";
        userService.delete(id);
    }

    @Test
    public void find() throws Exception {
        List<User> users = userService.find(null);
        users.forEach((user -> {
            logger.info(user + "");
            user.getRoles().forEach((role -> logger.info(role + "")));
        }));
    }

    @Before
    public void init() throws Exception {
        userService = context.getBean(UserService.class);
        ids = new String[]{"20c6705d-455f-4ecf-bc48-cb80bd3561eb", "1b5b6967-08d8-43b9-8fff-4610aa71fbd6"};
    }

    @Test
    public void isN(){
        String id = "7ee8d486-571a-4d13-a6b6-e6dc23a5b333";
        String password = "N2VlOGQ0ODYtNTcxYS00ZDEzLWE2YjYtZTZkYzIzYTViMzMzMTIzNDU2";
        password = ZhouBase64.isDecode(password);
        int index = id.length();
        password = password.substring(index,password.length());
        System.out.println(password);
    }

}
