package study.IOC;

import cn.blue.jk.util.SqlDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class Demo2 {
    private Logger logger = Logger.getLogger("" + this);
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void sqldao(){
        SqlDao sqlDao = (SqlDao)context.getBean("sqlDao");
        System.out.println(sqlDao);
    }
}
