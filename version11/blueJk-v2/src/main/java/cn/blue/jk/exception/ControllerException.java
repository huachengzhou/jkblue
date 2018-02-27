package cn.blue.jk.exception;

import cn.blue.common.exception.ControllerEnum;

public class ControllerException extends Exception {
    public ControllerException() {
        super(ControllerEnum.CONTROLLER_ENUM.getVar());
    }
}
