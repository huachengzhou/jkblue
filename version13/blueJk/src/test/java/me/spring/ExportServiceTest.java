package me.spring;

import cn.blue.jk.domain.Export;
import cn.blue.jk.service.ExportService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.UUID;
import java.util.logging.Logger;

public class ExportServiceTest {
    private Logger logger = Logger.getLogger("" + this);
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    private ExportService exportService = null;

    @Test
    public void get() {
        Export export = exportService.get("123");
        logger.info(export + "");
    }

    @Test
    public void add() {
        Export export = new Export();
        export.setId(UUID.randomUUID().toString());
        export.setInputDate(new Date(System.currentTimeMillis()));
        export.setContractIds("d3f8788e-054b-43fd-8f8b-84617a8e6fe2");
        exportService.insert("63394ae2-ba0a-4a8c-87dd-5677832c3402");
//        exportService.insert(export);
//        logger.info(export + "");
    }

    @Test
    public void remove(){
        String[] ids = {"27569e5d-b369-42f8-a09a-adc3892cb9d1"};
        exportService.delete(ids);
    }

    @Test
    public void update() {
        exportService.updateStop("123");
        Export export = exportService.get("123");
//        export.setMarks("1");
//        exportService.update(export);
//        export = exportService.get("123");
//        System.out.println(export.getMarks());

        System.out.println(export.getState());
    }


    @Test
    public void list() {
        exportService.find(null).stream().parallel().forEach((export -> logger.info(export + "")));
    }

    @Before
    public void init() {
        exportService = (ExportService) context.getBean("exportService");
    }

}
