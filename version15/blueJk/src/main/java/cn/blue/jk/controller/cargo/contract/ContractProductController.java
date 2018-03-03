package cn.blue.jk.controller.cargo.contract;

import cn.blue.common.view.VIEW;
import cn.blue.jk.controller.BaseController;
import cn.blue.jk.domain.ContractProduct;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.exception.ControllerException;
import cn.blue.jk.service.ContractProductService;
import cn.blue.jk.service.FactoryService;
import cn.blue.jk.util.UpFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 合同　controller
 *
 * @author zhou
 * @version 1.1
 * @see
 * @since jdk1.8
 */
@Controller
public class ContractProductController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContractProductService contractProductService;

    @Autowired
    private FactoryService factoryService;

    @RequestMapping(value = "/cargo/contractproduct/tocreate.action")
    public String toCreateView(@RequestParam(value = "contractId") String contractId, Map<String, Object> map) throws ControllerException, Exception {
        //准备生产厂家的下拉列表
        List<Factory> factoryList = factoryService.getFactoryList();
        List<ContractProduct> dataList = contractProductService.findContractId(contractId);

        map.put("dataList", dataList);
        map.put("factoryList", factoryList);
        map.put("contractId", contractId);

        logger.info("/cargo/contractproduct/tocreate.action");
        logger.info(VIEW.Pages.getVar() + "cargo/contract/jContractProductCreate" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "cargo/contract/jContractProductCreate" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contractproduct/insert.action")
    public String addContractProduct(Map<String, Object> map, ContractProduct contractProduct,@RequestParam(value = "productImageC")MultipartFile file,HttpServletRequest request) throws ControllerException, Exception {
        String path = request.getSession().getServletContext().getRealPath("/") + "/ufiles/"+file.getOriginalFilename();
        contractProduct.setId(UUID.randomUUID().toString());
        contractProduct.setAmount(contractProduct.getPrice() * contractProduct.getBoxNum());
        contractProduct.setProductImage("/ufiles/"+file.getOriginalFilename());
        UpFileUtil.uploadFile(path,file.getInputStream());
        contractProduct.setLoadingRate("1/3");
        contractProductService.insert(contractProduct);
        map.put("contractId", contractProduct.getContractId());
        logger.info(contractProduct + ""+file.getOriginalFilename()+"---"+file.getName());
        logger.info("/cargo/contractproduct/insert.action");
        return "redirect:/cargo/contractproduct/tocreate.action";//新增完转向新增页面-批量新增
    }

    @RequestMapping(value = "/cargo/contractproduct/delete.action")
    public String toRemove(@RequestParam(value = "id") String id, String contractId, Map<String, Object> map) throws ControllerException, Exception {
        String[] ids = id.split(",");
        contractProductService.delete(ids);
        map.put("contractId", contractId);//传递主表ID
        logger.info(id);
        return "redirect:/cargo/contractproduct/tocreate.action";
    }

    /**
     * 转向修改页面
     *
     * @param map
     * @param id
     * @return
     * @throws ControllerException
     * @throws Exception
     */
    @RequestMapping(value = "/cargo/contractproduct/toupdate.action")
    public String toUpdateView(Map<String, Object> map, @RequestParam(value = "id") String id) throws ControllerException, Exception {
        ContractProduct obj = contractProductService.get(id);
        map.put("obj", obj);
        //准备生产厂家的下拉列表
        List<Factory> factoryList = factoryService.getFactoryList();
        map.put("factoryList", factoryList);
        logger.info("/cargo/contractproduct/toupdate.action");
        return VIEW.Pages.getVar() + "cargo/contract/jContractProductUpdate" + VIEW.JSP.getVar();
    }

    /**
     * @param contractProduct
     * @return
     */
    @RequestMapping(value = "/cargo/contractproduct/update.action")
    public String update(ContractProduct contractProduct, @RequestParam(value = "contractId") String contractId, Model model,@RequestParam(value = "productImageC")MultipartFile file,HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/") + "/ufiles/"+file.getOriginalFilename();
        contractProduct.setProductImage("/ufiles/"+file.getOriginalFilename());
        try {
            UpFileUtil.uploadFile(path,file.getInputStream());
        }catch (IOException e){
            logger.error("异常咯 "+e.getLocalizedMessage());
            e.printStackTrace();
        }
        contractProductService.update(contractProduct);
        logger.info("" + contractProduct);
        model.addAttribute("contractId", contractId);
        return "redirect:/cargo/contractproduct/tocreate.action";
    }
}
