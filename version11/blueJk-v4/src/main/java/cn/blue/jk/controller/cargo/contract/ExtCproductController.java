package cn.blue.jk.controller.cargo.contract;

import cn.blue.common.view.VIEW;
import cn.blue.jk.controller.BaseController;
import cn.blue.jk.domain.ExtCproduct;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.domain.SysCode;
import cn.blue.jk.exception.ControllerException;
import cn.blue.jk.service.ExtCproductService;
import cn.blue.jk.service.FactoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 附件
 *
 * @author zhou
 * @version 1.1
 * @see
 * @since jdk1.8
 */
@Controller
public class ExtCproductController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/cargo/extcproduct/tocreate.action")
    public String tocreate(String contractProductId, Model model) throws ControllerException {

        //某个货物下的附件信息
        Map<String, Object> map = new HashMap<>();
        map.put(ExtCproductService.contractProductId, contractProductId);
        List<ExtCproduct> extCproductList = extCproductService.find(map);
        model.addAttribute("dataList", extCproductList);

        //准备生产厂家的下拉列表
        List<Factory> factories = factoryService.getFactoryList();
        model.addAttribute("factoryList", factories);

        //准备分类下拉列表
        List<SysCode> ctypeList = extCproductService.findSysCode(null);
        model.addAttribute("ctypeList", ctypeList);
        model.addAttribute("contractProductId",contractProductId);

        logger.info("/cargo/extcproduct/tocreate.action");
        return VIEW.Pages.getVar() + "cargo/contract/jExtCproductCreate" + VIEW.JSP.getVar();
    }

    /**
     * 添加数据
     *
     * @param extCproduct
     * @param model
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/extcproduct/insert.action")
    public String insert(ExtCproduct extCproduct, Model model) throws ControllerException {
        try {
            String productDesc = URLDecoder.decode(extCproduct.getProductDesc(), "UTF-8");
            String productRequest = URLDecoder.decode(extCproduct.getProductRequest(), "UTF-8");
            extCproduct.setProductRequest(productRequest);
            extCproduct.setProductDesc(productDesc);
            extCproduct.setId(UUID.randomUUID().toString());
            extCproductService.insert(extCproduct);
            System.out.println(extCproduct);
        } catch (Exception e) {
            logger.error("error:" + e.getMessage());
        }
        model.addAttribute(""+ExtCproductService.contractProductId, extCproduct.getContractProductId());        //传递主表ID
        return "redirect:/cargo/extcproduct/tocreate.action";
    }

    /**
     * 转向修改
     *
     * @param id
     * @param model
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/extcproduct/toupdate.action")
    public String toupdate(@RequestParam(value = "id") String id, Model model) throws ControllerException {
        ExtCproduct extCproduct = extCproductService.get(id);
        model.addAttribute("obj", extCproduct);
        //准备生产厂家的下拉列表
        List<Factory> factoryList = factoryService.getFactoryList();
        model.addAttribute("factoryList", factoryList);

        //准备分类下拉列表
        List<SysCode> ctypeList = extCproductService.findSysCode(null);
        model.addAttribute("ctypeList", ctypeList);
        return VIEW.Pages.getVar() + "cargo/contract/jExtCproductUpdate" + VIEW.JSP.getVar();
    }

    /**
     * 修改数据
     *
     * @param extCproduct
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/extcproduct/update.action")
    public String update(ExtCproduct extCproduct, Model model) throws ControllerException {
        extCproductService.update(extCproduct);
        model.addAttribute("contractProductId", extCproduct.getContractProductId());//传递主表ID
        return "redirect:/cargo/extcproduct/tocreate.action";
    }

    /**
     * 删除
     *
     * @param contractProductId
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/cargo/extcproduct/delete.action")
    public String delete(String contractProductId, @RequestParam(value = "id") String id, Model model) {
        String[] ids = id.split(",");
        extCproductService.delete(ids);
        model.addAttribute("contractProductId", contractProductId);//传递主表ID
        return "redirect:/cargo/extcproduct/tocreate.action";
    }

    @Lazy
    @Autowired
    private FactoryService factoryService;

    @Lazy
    @Autowired
    private ExtCproductService extCproductService;
}
