package me.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class SqlSessionFactoryTest {
    private Logger logger = Logger.getLogger(toString());

    @Test
    public void sqlSessionTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SqlSessionFactory sessionFactory = null;
        sessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        logger.info(sessionFactory + "");
    }

}
