package me.spring;

import cn.blue.jk.domain.ExtEproduct;
import cn.blue.jk.service.ExtEproductService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;


public class ExtEproductServiceTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private ExtEproductService service;

    @Test
    public void get() {
        String id = "123";
        ExtEproduct extEproduct = service.get(id);
        logger.info(extEproduct + "");
    }

    @Test
    public void add(){
        ExtEproduct extEproduct = new ExtEproduct();
        extEproduct.setId(UUID.randomUUID().toString());
        service.insert(extEproduct);
    }

    @Test
    public void update(){
        String id = "123";
        ExtEproduct extEproduct = service.get(id);
        extEproduct.setAmount(234.3);
        service.update(extEproduct);
        extEproduct = service.get(id);
        logger.info(extEproduct.getAmount()+"");
    }

    @Test
    public void remove(){
        String[] ids = {"0753a4a5-3124-423b-8021-8787b8a77ea6"};
        service.delete(ids);
    }

    @Test
    public void list(){
        service.find(null).stream().parallel().forEach((extEproduct -> logger.info(""+extEproduct)));
    }

    @Before
    public void init() {
        service = (ExtEproductService) context.getBean("extEproductService");
    }

}

