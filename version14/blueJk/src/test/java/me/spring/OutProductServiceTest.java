package me.spring;

import cn.blue.jk.service.OutProductService;
import cn.blue.jk.vo.OutProductVO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class OutProductServiceTest {
    private Logger logger = Logger.getLogger(toString());
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private OutProductService outProductService = null;

    @Test
    public void out(){
        List<OutProductVO> outProductVOS = outProductService.outProducts("2018");
        outProductVOS.forEach((outProductVO -> System.out.println(outProductVO)));
    }


    @Before
    public void init(){
        outProductService = context.getBean(OutProductService.class);
    }

}
