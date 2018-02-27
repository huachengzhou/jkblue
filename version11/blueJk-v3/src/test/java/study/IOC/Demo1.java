package study.IOC;

import cn.blue.jk.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring1.xml");

    @Test
    public void init(){
        User user1 = (User) context.getBean("user1");
        System.out.println(user1);

        User user2 = (User) context.getBean("user2");
        System.out.println(user2);
    }
}
