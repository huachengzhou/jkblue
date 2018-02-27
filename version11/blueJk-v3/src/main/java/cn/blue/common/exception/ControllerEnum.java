package cn.blue.common.exception;

public enum ControllerEnum {
    CONTROLLER_ENUM("controller异常");
    private String var;

    ControllerEnum(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
