package me.spring;

import cn.blue.jk.domain.Factory;
import cn.blue.jk.service.FactoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;
import java.util.logging.Logger;

public class FactoryServiceTest {
    Logger logger = Logger.getLogger(toString());
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private FactoryService factoryService = null;

    @Test
    public void delete() throws Exception {
        factoryService.delete(new String[]{"2", "3"});
    }

    @Test
    public void deleteById() throws Exception {
        factoryService.deleteById(1);
    }

    @Test
    public void updateState() throws Exception {
        String[] ids = {"25", "24306846-79f9-4daf-8612-47adb2687f04"};
        factoryService.updateStateStop(ids);
    }

    @Test
    public void updateStateStart() throws Exception {
        factoryService.updateStateStop(1);
        Factory factory = factoryService.get(1);
        System.out.println(factory.getState());
    }

    @Test
    public void update() throws Exception {
        Factory factory = factoryService.get("71e93b71-4c04-4346-9d8a-d19d27e630c1");
        logger.info(factory + "");
        factory.setFactoryName("blake");
        factoryService.update(factory);
        logger.info(factory + "");
    }

    @Test
    public void insert() throws Exception {
        Factory factory = new Factory();
        factory.setId(UUID.randomUUID().toString().substring(20));
        factory.setFactoryName(1 + "");
        logger.info(factory + "");
        factoryService.insert(factory);
    }

    @Test
    public void get() throws Exception {
        String id = "24306846-79f9-4daf-8612-47adb2687f04";
        FactoryService factoryService1 = context.getBean(FactoryService.class);
        FactoryService factoryService2 = context.getBean(FactoryService.class);
        Factory factory1 = factoryService1.get(id);
        Factory factory2 = factoryService2.get(id);
        System.out.println(factory1);
        System.out.println(factory2);
    }

    @Before
    public void init() {
        factoryService = context.getBean(FactoryService.class);
    }
}
