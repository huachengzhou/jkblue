package cn.blue.jk.controller.basicinfo.factory;

import cn.blue.common.view.VIEW;
import cn.blue.jk.dao.FactoryDao;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class FactoryController {
    private Logger logger = Logger.getLogger(toString());

    @Autowired
    private FactoryDao factoryDao;

    @Resource
    private FactoryService factoryService;

    @RequestMapping(value = "/basicinfo/factory/list.action")
    public String list(Map<String, Object> map) throws Exception {
        List<Factory> factoryList = factoryService.find(null);
        map.put("dataList", factoryList);
        logger.info("" + map);
        logger.info("/basicinfo/factory/list.action");
//        logger.info("test() factoryDao ==>" + factoryDao.find(null));
        /**
         *  nested exception is org.apache.ibatis.exceptions.PersistenceException:
         *  Error querying database.  Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for null.find
         *  Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for null.find
         *
         *
         *  org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:23)
         org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:107)
         org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:98)
         cn.blue.jk.dao.base.impl.BaseDaoImpl.find(BaseDaoImpl.java:38)
         cn.blue.jk.dao.impl.FactoryDaoImpl.find(FactoryDaoImpl.java:27)
         cn.blue.jk.controller.basicinfo.factory.FactoryController.list(FactoryController.java:32)
         sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
         sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         java.lang.reflect.Method.invoke(Method.java:498)
         */
        return VIEW.Pages.getVar() + "basicinfo/factory/jFactoryList" + VIEW.JSP.getVar();
    }
}
