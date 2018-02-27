package cn.blue.jk.controller;

import cn.blue.common.view.VIEW;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class HomeController {
    private Logger logger = Logger.getLogger(toString());
    //系统首页模块

    @RequestMapping(value = {"/home.action"})
    public String login() {
        logger.info(VIEW.Pages.getVar() + "login" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "login" + VIEW.JSP.getVar();            //首页，删除根目录下index.jsp，否则上面url将被拦截进不来
    }

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
}
