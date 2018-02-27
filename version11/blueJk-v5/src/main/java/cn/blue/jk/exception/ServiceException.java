package cn.blue.jk.exception;

import cn.blue.common.exception.Service;

public class ServiceException extends RuntimeException {
    public ServiceException() {
        super(Service.SERVICE_NUM.getVar());
    }
}
