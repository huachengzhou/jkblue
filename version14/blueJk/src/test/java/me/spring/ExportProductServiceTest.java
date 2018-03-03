package me.spring;

import cn.blue.jk.domain.ExportProduct;
import cn.blue.jk.service.ExportProductService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;
import java.util.logging.Logger;

public class ExportProductServiceTest {
    private Logger logger = Logger.getLogger("" + this);
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    private ExportProductService service;

    @Test
    public void get() {
        String id = "ce550741-2f90-42fa-8bfb-1e03fc070171";
        ExportProduct exportProduct = service.get(id);
        logger.info(""+exportProduct);
    }

    @Test
    public void list(){
        service.find(null).stream().parallel().forEach((exportProduct -> logger.info(""+exportProduct)));
    }

    @Test
    public void remove(){
        String[] ids = {"ce550741-2f90-42fa-8bfb-1e03fc070171"};
        service.delete(ids);
    }

    @Test
    public void update(){
        String id = "ce550741-2f90-42fa-8bfb-1e03fc070171";
        ExportProduct exportProduct = service.get(id);
        exportProduct.setBoxNum(2);
        service.update(exportProduct);
        exportProduct = service.get(id);
        System.out.println(exportProduct.getBoxNum());
    }

    @Test
    public void add() {
        ExportProduct exportProduct = new ExportProduct();
        exportProduct.setId(UUID.randomUUID().toString());
        exportProduct.setExportId("123");
        exportProduct.setFactoryId("843b87d4-8bc9-423d-a3ca-c9521f54f976");
        exportProduct.setFactoryName("A");
        service.insert(exportProduct);
        logger.info(exportProduct + "");
    }

    @Before
    public void init() {
        service = (ExportProductService) context.getBean("exportProductService");
    }

}
