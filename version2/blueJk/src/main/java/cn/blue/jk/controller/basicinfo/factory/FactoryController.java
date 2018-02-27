package cn.blue.jk.controller.basicinfo.factory;

import cn.blue.common.view.VIEW;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class FactoryController {
    private Logger logger = Logger.getLogger(toString());


    @Resource
    private FactoryService factoryService;

    @RequestMapping(value = "/basicinfo/factory/list.action")
    public String list(Map<String, Object> map) throws Exception {
        List<Factory> factoryList = factoryService.find(null);
        map.put("dataList", factoryList);
        logger.info("" + map);
        logger.info("/basicinfo/factory/list.action");
        return VIEW.Pages.getVar() + "basicinfo/factory/jFactoryList" + VIEW.JSP.getVar();
    }
}
