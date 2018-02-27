package me.spring;

import cn.blue.jk.domain.Contract;
import cn.blue.jk.service.ContractService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class ContractServiceTest {
    private Logger logger = Logger.getLogger(toString());
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private ContractService service;

    @Test
    public void get()throws Exception{
        String id = "4028817a33812ffd013382048ff80024";
        Contract contract = service.get(id);
        logger.info(contract+"");
    }

    @Before
    public void init() {
        service = context.getBean(ContractService.class);
    }
}
