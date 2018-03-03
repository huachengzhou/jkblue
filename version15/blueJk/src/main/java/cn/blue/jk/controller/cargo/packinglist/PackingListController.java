package cn.blue.jk.controller.cargo.packinglist;

import cn.blue.common.factory.FactoryState;
import cn.blue.common.view.VIEW;
import cn.blue.jk.domain.PackingList;
import cn.blue.jk.exception.ControllerException;
import cn.blue.jk.service.PackingListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class PackingListController {

    /**
     * show 装箱
     *
     * @param model
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/packinglist/list.action")
    public String list(Model model) throws ControllerException {
        List<PackingList> dataList = packingListService.find(null);
        model.addAttribute("dataList", dataList);
        logger.info("/cargo/packinglist/list.action");
        return VIEW.Pages.getVar() + "cargo/packinglist/jPackingListList" + VIEW.JSP.getVar();
    }

    /**
     * 创建　装箱
     *
     * @param id
     * @param model
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/packinglist/tocreate.action")
    public String tocreate(String id, Model model) throws ControllerException {
        if (id != null) {
            String exportIds = id;
            String exportNos = packingListService.toExportNos(id);
            model.addAttribute("exportIds", exportIds);
            model.addAttribute("exportNos", exportNos);
            logger.info("/cargo/packinglist/tocreate.action" + id);
        }
        return VIEW.Pages.getVar() + "cargo/packinglist/jPackingListCreate" + VIEW.JSP.getVar();
    }

    /**
     * 装箱增加
     *
     * @param packingList
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/packinglist/insert.action")
    public String insert(PackingList packingList) throws ControllerException {
        if (packingList != null) {
            packingList.setCreateTime(new Date(System.currentTimeMillis()));
            packingList.setId(UUID.randomUUID().toString());
            packingList.setState(Integer.parseInt(FactoryState.FACTORY_STATE_STOP.getState()));
            packingListService.insert(packingList);
            logger.info("" + packingList);
        }
        return "redirect:/cargo/packinglist/list.action";
    }

    /**
     * 装箱删除
     *
     * @param id
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/packinglist/delete.action")
    public String delete(String id) throws ControllerException {
        if (id != null) {
            String[] ids = id.split(",");
            packingListService.delete(ids);
            logger.info("/cargo/packinglist/delete.action");
        }
        return "redirect:/cargo/packinglist/list.action";
    }

    /**
     * 转到更新页面
     * @param id
     * @param model
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/packinglist/toupdate.action")
    public String toupdate(String id, Model model) throws ControllerException {
        if (id != null) {
            PackingList obj = packingListService.get(id);
            model.addAttribute("obj", obj);
            model.addAttribute("exportNos", obj.getExportNos());
            model.addAttribute("exportIds", obj.getExportIds());
            logger.info("/cargo/packinglist/toupdate.action" + id);
        }
        return VIEW.Pages.getVar() + "cargo/packinglist/jPackingListUpdate" + VIEW.JSP.getVar();
    }

    /**
     * 更新装箱
     * @param packingList
     * @return
     */
    @RequestMapping(value = "/cargo/packinglist/update.action")
    public String update(PackingList packingList) {
        packingListService.update(packingList);
        return "redirect:/cargo/packinglist/list.action";
    }

    /**
     * 上报
     * @param id
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/packinglist/submit.action")
    public String submit(String id) throws ControllerException {
        if (id != null) {
            String[] ids = id.split(",");
            packingListService.updateStart(ids);
            logger.info("/cargo/packinglist/submit.action" + id);
        }
        return "redirect:/cargo/packinglist/list.action";
    }

    /**
     * 取消
     * @param id
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/packinglist/cancel.action")
    public String cancel(String id) throws ControllerException {
        if (id != null) {
            String[] ids = id.split(",");
            packingListService.updateStop(ids);
            logger.info("/cargo/packinglist/cancel.action" + id);
        }
        return "redirect:/cargo/packinglist/list.action";
    }

    /**
     * 装箱查看
     * @param id
     * @param model
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/packinglist/toview.action")
    public String toview(String id,Model model)throws ControllerException {
        if (id != null) {
            PackingList obj = packingListService.get(id);
            model.addAttribute("obj", obj);
            model.addAttribute("exportNos", obj.getExportNos());
            model.addAttribute("exportIds", obj.getExportIds());
            logger.info("/cargo/packinglist/toview.action" + id);
        }
        return VIEW.Pages.getVar() + "cargo/packinglist/jPackingListView" + VIEW.JSP.getVar();
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Lazy
    @Autowired
    private PackingListService packingListService;
}
