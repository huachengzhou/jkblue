package me.spring;

import cn.blue.jk.domain.PackingList;
import cn.blue.jk.service.PackingListService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.UUID;

public class PackingListServiceTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private PackingListService service;

    @Test
    public void get() {
        String id = "f32a5661-1504-445f-adaf-1aa1a5b09d7a";
        PackingList packingList = service.get(id);
        logger.info(""+packingList);
    }

    @Test
    public void update(){
        String id = "f32a5661-1504-445f-adaf-1aa1a5b09d7a";
        PackingList packingList = service.get(id);
        packingList.setInvoiceDate(new Date(System.currentTimeMillis()));
        service.update(packingList);
        packingList = service.get(id);
        System.out.println(packingList);
    }

    @Test
    public void delete(){
        String[] ids = {""};
        service.delete(ids);
    }

    @Test
    public void moreupdate(){
        String[] ids = {"f32a5661-1504-445f-adaf-1aa1a5b09d7a"};
        service.updateStart(ids);
    }

    @Test
    public void list(){
        service.find(null).forEach(packingList -> logger.info(""+packingList));
    }

    @Test
    public void add() {
        PackingList packingList = new PackingList(UUID.randomUUID().toString());
        service.insert(packingList);
        logger.info(packingList + "");
    }

    @Before
    public void init() {
        service = (PackingListService) context.getBean("packingListService");
    }
}
