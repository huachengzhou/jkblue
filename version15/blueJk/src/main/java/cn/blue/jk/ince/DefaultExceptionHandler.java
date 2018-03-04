package cn.blue.jk.ince;

import cn.blue.common.view.VIEW;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@ControllerAdvice
public class DefaultExceptionHandler {
    private final String pathA = VIEW.Pages.getVar() + "sys/";
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e, Model model) {
        model.addAttribute("exception", "shiro exception:" + e.getMessage());
        return pathA+"exception/unauthorized.jsp";
    }

    @ExceptionHandler({HttpMessageNotWritableException.class, ConversionNotSupportedException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//server code 500
    public String conversionNotSupportedExceptionEx(HttpMessageNotWritableException ex, Model model) {
        model.addAttribute("ex", "exception:" + ex.getMessage());
        return pathA+"exception/500.jsp";
    }

    @ExceptionHandler({NoSuchRequestHandlingMethodException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)//server code 404
    public String NoSuchRequestHandlingMethodException_eX(Model model, NoSuchRequestHandlingMethodException ex) {
        model.addAttribute("ex", "exception:" + ex.getMessage());
        return pathA+"exception/404.jsp";
    }

    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)//SERVER CODE 415
    public String httpMediaTypeNotSupportedException_eX(Model model, HttpMediaTypeNotSupportedException ex) {
        model.addAttribute("ex", "exception:" + ex.getMessage());
        return pathA+"exception/415.jsp";
    }

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class, MissingServletRequestParameterException.class
            , MissingServletRequestPartException.class, TypeMismatchException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)//code 其实有多个呢,这只写这一个
    public String bindException(Model model, BindException ex) {
        model.addAttribute("ex", "exception:" + ex.getMessage());
        return pathA+"exception/400.jsp";
    }
}
