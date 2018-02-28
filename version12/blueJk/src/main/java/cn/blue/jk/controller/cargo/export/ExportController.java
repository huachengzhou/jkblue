package cn.blue.jk.controller.cargo.export;

import cn.blue.common.view.VIEW;
import cn.blue.jk.domain.Export;
import cn.blue.jk.exception.ControllerException;
import cn.blue.jk.service.ExportService;
import cn.blue.jk.vo.ContractVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 出口报运
 */
@Controller
public class ExportController {

    /**
     * 出口报运列表
     *
     * @param model
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/export/list.action")
    public String list(Model model) throws ControllerException {
        List<Export> dataList = exportService.find(null);
        model.addAttribute("dataList", dataList);
        logger.info("/cargo/export/list.action");
        return VIEW.Pages.getVar() + "cargo/export/jExportList" + VIEW.JSP.getVar();
    }

    /**
     * 购销合同查询列表
     *
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/export/contractList.action")//
    public String contractList(Model model) throws ControllerException {
        List<ContractVO> contracts = exportService.getContractList();
        model.addAttribute("dataList", contracts);
        logger.info("/cargo/export/contractList.action");
        return VIEW.Pages.getVar() + "cargo/export/jContractList" + VIEW.JSP.getVar();
    }

    /**
     * 报运 insert
     *
     * @param id
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/export/insert.action")
    public String add(@RequestParam(value = "id") String id) throws ControllerException {
        if (id != null && id != "" && id.length() > 0) {
            String[] contractIds = id.split(",");
            exportService.insert(contractIds);
            logger.info("/cargo/export/insert.action " + id);
        }
        return "redirect:/cargo/export/list.action";
    }

    @RequestMapping(value = "/cargo/export/toview.action")
    public String toView(@RequestParam(value = "id") String id) throws ControllerException {
        logger.info("/cargo/export/toview.action" + id);
        return "";
    }

    /**
     * 出口上报
     *
     * @param id
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/export/submit.action")
    public String submit(@RequestParam(value = "id") String id) throws ControllerException {
        String[] ids = id.split(",");
        logger.info("/cargo/export/submit.action" + id);
        for (int i = 0; i < ids.length; i++) exportService.updateStart(ids[i]);
        return "redirect:/cargo/export/list.action";
    }

    /**
     * 出口上报取消
     *
     * @param id
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/export/cancel.action")
    public String cancel(@RequestParam(value = "id") String id) throws ControllerException {
        String[] ids = id.split(",");
        logger.info("/cargo/export/cancel.action" + id);
        for (int i = 0; i < ids.length; i++) exportService.updateStop(ids[i]);
        return "redirect:/cargo/export/list.action";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/export/delete.action")
    public String remove(@RequestParam(value = "id") String id) throws ControllerException {
        String[] ids = id.split(",");
        logger.info("/cargo/export/delete.action" + id);
        if (ids != null) exportService.delete(ids);
        return "redirect:/cargo/export/list.action";
    }

    /**
     * 修改
     *
     * @param id
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/export/toupdate.action")
    public String toupdate(@RequestParam(value = "id") String id, Model model) throws ControllerException {
        if (id != null) {
            logger.info("/cargo/export/toupdate.action" + id);
            Export obj = exportService.get(id);
            model.addAttribute("obj", obj);
            //准备批量修改控件的数据mrecord
            model.addAttribute("mRecordData", exportService.getMrecordData(id));
        }
        return VIEW.Pages.getVar() + "cargo/export/jExportUpdate" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/export/update.action")
    public String update(Export export){
        if (export!=null){
            exportService.update(export);
        }
        return "redirect:/cargo/export/list.action";
    }

    @Autowired
    private ExportService exportService;


    private Logger logger = LoggerFactory.getLogger(this.getClass());
}
