package cn.blue.jk.controller.cargo.contract;

import cn.blue.common.view.VIEW;
import cn.blue.jk.controller.BaseController;
import cn.blue.jk.domain.ContractProduct;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.service.ContractProductService;
import cn.blue.jk.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
public class ContractProductController extends BaseController {
    private Logger logger = Logger.getLogger(this + "");

    @Autowired
    private ContractProductService contractProductService;

    @Autowired
    private FactoryService factoryService;

    @RequestMapping(value = "/cargo/contractproduct/tocreate.action")
    public String toCreateView(@RequestParam(value = "contractId") String contractId, Map<String, Object> map) throws Exception {
        //准备生产厂家的下拉列表
        List<Factory> factoryList = factoryService.getFactoryList();
        List<ContractProduct> dataList = contractProductService.findContractId(contractId);

        map.put("dataList", dataList);
        map.put("factoryList", factoryList);
        map.put("contractId",contractId);

        logger.info("/cargo/contractproduct/tocreate.action");
        logger.info(VIEW.Pages.getVar() + "cargo/contract/jContractProductCreate" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "cargo/contract/jContractProductCreate" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contractproduct/insert.action")
    public String addContractProduct(Map<String, Object> map, ContractProduct contractProduct) throws Exception {
        contractProduct.setId(UUID.randomUUID().toString());
        contractProduct.setAmount(contractProduct.getPrice()*contractProduct.getBoxNum());
        contractProductService.insert(contractProduct);
        map.put("contractId", contractProduct.getContractId());
        logger.info(contractProduct+"");
        logger.info("/cargo/contractproduct/insert.action");
        return "redirect:/cargo/contractproduct/tocreate.action";//新增完转向新增页面-批量新增
    }
}
