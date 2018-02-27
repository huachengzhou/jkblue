package me.spring.other;

import cn.blue.jk.util.AAA;
import cn.blue.jk.util.InitData;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class Demo1 {
    private Logger logger = Logger.getLogger("" + this);
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void initData() {
        InitData initData = (InitData) context.getBean(InitData.class);
        System.out.println(initData.uuid());
        AAA aaa = context.getBean(AAA.class);
        System.out.println(aaa);
    }
}
