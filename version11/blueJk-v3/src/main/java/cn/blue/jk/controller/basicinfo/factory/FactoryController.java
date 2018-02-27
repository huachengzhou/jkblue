package cn.blue.jk.controller.basicinfo.factory;

import cn.blue.common.view.VIEW;
import cn.blue.jk.controller.BaseController;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.exception.ControllerException;
import cn.blue.jk.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
    public String list(Map<String, Object> map) throws ControllerException,Exception {
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
    public String factoryCreate() throws ControllerException{
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
    public String addFactory(Factory factory) throws ControllerException,Exception {
        factory.setId(UUID.randomUUID().toString());
        factory.setState("1");//状态标识符 默认启用
        factory.setCreateTime(new Date(System.currentTimeMillis()));
        String fullName = URLDecoder.decode(factory.getFullName(),"UTF-8");
        String factoryName = URLDecoder.decode(factory.getFactoryName(),"UTF-8");
        factory.setFullName(fullName);
        factory.setFactoryName(factoryName);
        factoryService.insert(factory);
        logger.info("" + factory);
        logger.info("insert.action");
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * 转到修改页面
     *
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toupdate.action")
    public String factoryUpdate(Map<String, Object> map, @RequestParam String id) throws ControllerException,Exception {
        Factory factory = factoryService.get(id);
        map.put("obj", factory);
        logger.info("/toupdate.action" + map);
        return VIEW.Pages.getVar() + "basicinfo/factory/jFactoryUpdate" + VIEW.JSP.getVar();
    }

    /**
     * 修改Factory 信息
     *
     * @param factory
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/basicinfo/factory/update.action")
    public String factoryUpdate(Factory factory) throws ControllerException,Exception {
        factoryService.update(factory);
        logger.info("/update.action" + factory);
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * 删除单个 Factory
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteById.action")
    public String removeFactory(@RequestParam(value = "id") String id) throws ControllerException,Exception {
        factoryService.deleteById(id);
        logger.info("/deleteById.action");
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * 删除多个 Factory
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete.action")
    public String removeFactoryN(@RequestParam(value = "id") String ids) throws ControllerException,Exception {
        factoryService.delete(ids.split(","));
        logger.info("/delete.action" + ids);
        return "redirect:/basicinfo/factory/list.action";
    }


    /**
     * show one Factory
     *
     * @param id
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toview.action")
    public String showFactoryById(@RequestParam(value = "id") String id, Map<String, Object> map) throws ControllerException,Exception {
        Factory factory = factoryService.get(id);
        map.put("obj", factory);
        logger.info("/toview.action" + map);
        return VIEW.Pages.getVar() + "basicinfo/factory/jFactoryView" + VIEW.JSP.getVar();
    }

    /**
     * 启用 factory
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/start.action")
    public String startStateFactory(@RequestParam(value = "id") String id) throws ControllerException,Exception {
        factoryService.updateStateStart(id);
        logger.info("/start.action " + id);
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * 启用　多个 factory
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/startMore.action")
    public String startStateMoreFactory(@RequestParam(value = "id") String ids) throws ControllerException,Exception {
        factoryService.updateStateStart(ids.split(","));
        logger.info("/startMore.action " + ids);
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * 停用 factory
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/stop.action")
    public String stopStateFactory(@RequestParam(value = "id") String id) throws ControllerException,Exception {
        factoryService.updateStateStop(id);
        logger.info("/stop.action " + id);
        return "redirect:/basicinfo/factory/list.action";
    }

    /**
     * 停用多个 factory
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/stopMore.action")
    public String stopStateMoreFactory(@RequestParam(value = "id") String ids) throws ControllerException,Exception {
        factoryService.updateStateStop(ids.split(","));
        logger.info("/stopMore.action " + ids);
        return "redirect:/basicinfo/factory/list.action";
    }
}
