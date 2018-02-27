package me.java8;

import cn.blue.jk.domain.ContractProduct;
import cn.blue.jk.service.ContractProductService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Demo1 {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ContractProductService service = null;

    @Before
    public void init() {
        service = context.getBean(ContractProductService.class);
    }

    @Test
    public void isN() throws Exception {
        String id = "53557cf1-7530-42b7-921b-6519288f822a";
        List<ContractProduct> contractProducts = service.findContractId(id);
        long start = System.currentTimeMillis();
//        contractProducts.stream().parallel().forEach((c) -> {
//            logger.info(c + "");
//        });
        contractProducts.stream().forEach((c) -> {
            logger.info(c + "");
        });
        long end = System.currentTimeMillis();
        System.out.println((end-start));
        //在数据量不大的情况下用并行效果并不明显
    }

}
