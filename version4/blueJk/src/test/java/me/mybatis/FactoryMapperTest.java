package me.mybatis;

import cn.blue.jk.domain.Factory;
import cn.blue.jk.mapper.FactoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class FactoryMapperTest {
    private Logger logger = Logger.getLogger(toString());
    FactoryMapper factoryMapper = null;
    SqlSession session = null;


    @Test
    public void find() throws Exception {
        List<Factory> factories = factoryMapper.find();
        factories.forEach((f) -> logger.info("" + f));
    }

    @After
    public void end() {
        if (session != null) session.close();
    }

    @Before
    public void isit() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SqlSessionFactory sessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        session = sessionFactory.openSession();
        factoryMapper = session.getMapper(FactoryMapper.class);
        logger.info(factoryMapper + "");
    }
}
