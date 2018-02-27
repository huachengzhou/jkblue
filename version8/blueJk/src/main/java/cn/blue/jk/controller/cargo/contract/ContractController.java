package cn.blue.jk.controller.cargo.contract;

import cn.blue.common.view.VIEW;
import cn.blue.jk.controller.BaseController;
import cn.blue.jk.domain.Contract;
import cn.blue.jk.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * 购销合同 控制器
 *
 * @author zhou
 * Date: 18-2-8
 * Time: 下午4:55
 */
@Controller
public class ContractController extends BaseController {
    private Logger logger = Logger.getLogger(this + "");

    @Autowired
    private ContractService contractService;

    @RequestMapping(value = "/cargo/contract/list.action")
    public String list(Map<String, Object> map) throws Exception {
        List<Contract> contractList = contractService.find(null);
        map.put("dataList", contractList);
        logger.info("/cargo/contract/list.action" + map);
        return VIEW.Pages.getVar() + "cargo/contract/jContractList" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contract/tocreate.action")
    public String toAddView(){
        logger.info("/cargo/contract/tocreate.action");
        logger.info(VIEW.Pages.getVar() + "cargo/contract/jContractCreate" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "cargo/contract/jContractCreate" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contract/insert.action")
    public String toAdd(Contract contract)throws Exception{
        contract.setId(UUID.randomUUID().toString());
        contractService.insert(contract);
        logger.info("/insert.action");
        return  "redirect:/cargo/contract/list.action";
    }

    @RequestMapping(value = "/cargo/contract/toupdate.action")
    public String toUpdateView(Map<String, Object> map, @RequestParam(value = "id") String id)throws Exception{
        Contract contract = contractService.get(id);
        map.put("obj",contract);
        logger.info(contract+"");
        logger.info("/cargo/contract/toupdate.action");
        logger.info(VIEW.Pages.getVar() + "cargo/contract/jContractUpdate" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "cargo/contract/jContractUpdate" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contract/update.action")
    public String toUpdate(Contract contract)throws Exception{
        contractService.update(contract);
        logger.info("/cargo/contract/update.action");
        logger.info(""+contract);
        return  "redirect:/cargo/contract/list.action";
    }

    @RequestMapping(value = "/cargo/contract/delete.action")
    public String toRemove(@RequestParam(value = "id") String id)throws Exception{// 单个　和多个都可以删除
        String[] ids = id.split(",");
        contractService.delete(ids);
        logger.info("/cargo/contract/delete.action");
        logger.info("remove param:"+id);
        return  "redirect:/cargo/contract/list.action";
    }

    @RequestMapping(value = "/cargo/contract/toview.action")
    public String toView(@RequestParam(value = "id") String id,Map<String, Object> map)throws Exception{
        Contract contract = contractService.get(id);
        map.put("obj",contract);
        logger.info("/cargo/contract/toview.action");
        logger.info("param "+contract);
        logger.info(VIEW.Pages.getVar() + "cargo/contract/jContractView" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "cargo/contract/jContractView" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contract/submit.action")
    public String toSubmit(@RequestParam(value = "id") String id)throws Exception{
        String[] ids = id.split(",");
        contractService.submit(ids);
        logger.info("/cargo/contract/submit.action");
        logger.info("param "+ids);
        return  "redirect:/cargo/contract/list.action";
    }

    @RequestMapping(value = "/cargo/contract/cancel.action")
    public String toCancel(@RequestParam(value = "id") String id)throws Exception{
        String[] ids = id.split(",");
        contractService.cancel(ids);
        logger.info("/cargo/contract/cancel.action");
        logger.info("param "+ids);
        return  "redirect:/cargo/contract/list.action";
    }
}
