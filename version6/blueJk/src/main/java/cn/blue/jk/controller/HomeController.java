package cn.blue.jk.controller;

import cn.blue.common.view.VIEW;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class HomeController {
    private Logger logger = Logger.getLogger(toString());

    /*-----------------------------------------------||-----------------------------------------------------------*/
    //系统首页模块

    /**
     * 转入登录模块
     *
     * @return
     */
    @RequestMapping(value = {"/home.action"})
    public String login() {
        logger.info(VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "sys/login" + VIEW.JSP.getVar();
    }

    /**
     * 转入主框架模块
     *
     * @return
     */
    @RequestMapping(value = "/fmain.action")
    public String fmain() {
        logger.info(VIEW.Pages.getVar() + "home/fmain" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "home/fmain" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/title.action")
    public String title() {
        logger.info(VIEW.Pages.getVar() + "home/title" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "home/title" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/left.action")
    public String left() {
        logger.info(VIEW.Pages.getVar() + "home/left" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "home/left" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/main.action")
    public String main() {
        logger.info(VIEW.Pages.getVar() + "home/olmsgList" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "home/olmsgList" + VIEW.JSP.getVar();//首页转向留言板
    }
    /*-----------------------------------------------||-----------------------------------------------------------*/

    //基础信息模块
    @RequestMapping("/baseinfoMain.action")
    public String baseinfoMain() {
        logger.info(VIEW.Pages.getVar() + "/baseinfo/main" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "/baseinfo/main" + VIEW.JSP.getVar();
    }

    @RequestMapping("/baseinfoLeft.action")
    public String baseinfoLeft() {
        logger.info(VIEW.Pages.getVar() + "baseinfo/left" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "baseinfo/left" + VIEW.JSP.getVar();
    }

}
