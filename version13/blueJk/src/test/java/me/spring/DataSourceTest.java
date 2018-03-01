package me.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.logging.Logger;

public class DataSourceTest {

    @Test
    public void dataSourceTest(){
        Logger logger = Logger.getLogger(toString());
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        logger.info(context+"");

        DataSource dataSource = context.getBean(DataSource.class);
        logger.info(dataSource+"");
    }
}
