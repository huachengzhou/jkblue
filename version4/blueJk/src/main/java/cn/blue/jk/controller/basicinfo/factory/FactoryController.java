package cn.blue.jk.controller.basicinfo.factory;

import cn.blue.common.view.VIEW;
import cn.blue.jk.controller.BaseController;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class FactoryController extends BaseController {
    private Logger logger = Logger.getLogger(toString());

    @Resource
    private FactoryService factoryService;

    /**
     * show factory data
     *
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/basicinfo/factory/list.action")
    public String list(Map<String, Object> map) throws Exception {
        List<Factory> factoryList = factoryService.find(null);
        map.put("dataList", factoryList);
        logger.info("" + map);
        logger.info("/basicinfo/factory/list.action");
        return VIEW.Pages.getVar() + "basicinfo/factory/jFactoryList" + VIEW.JSP.getVar();
    }


    /**
     * 转到　添加factory view
     *
     * @return
     */
    @RequestMapping(value = "/tocreate.action")
    public String factoryCreate() {
        logger.info("factoryCreate()");
        logger.info(VIEW.Pages.getVar() + "basicinfo/factory/jFactoryCreate" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "basicinfo/factory/jFactoryCreate" + VIEW.JSP.getVar();
    }


    /**
     * 添加数据
     *
     * @param factory
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/insert.action")
    public String addFactory(Factory factory) throws Exception {
        factoryService.insert(factory);
        logger.info("" + factory);
        logger.info("insert.action");
        return "redirect:/basicinfo/factory/list.action";
    }
}
