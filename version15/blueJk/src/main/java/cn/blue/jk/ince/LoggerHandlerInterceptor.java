package cn.blue.jk.ince;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 由于配置了shiro就不再使用spring的拦截器了,这里只是象征性的配置为日志,不拦截任何
 */
public class LoggerHandlerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView mv) throws Exception {
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.info("view name:" + mv.getViewName());
        log.info("参数名:" + mv.getModel());
        log.info("请求地址" + request.getRequestURI());
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
