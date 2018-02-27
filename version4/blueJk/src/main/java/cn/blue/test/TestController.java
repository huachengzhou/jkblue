package cn.blue.test;

import cn.blue.common.view.VIEW;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class TestController {

    @RequestMapping(value = "/testView.action")
    public String testView() {
        Logger logger = Logger.getLogger(toString());
        logger.info("testView()");
        return VIEW.VIEWS.getVar() + "success" + VIEW.JSP.getVar();
    }
}
