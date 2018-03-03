package cn.blue.common.exception;

public enum Service {
    SERVICE_NUM("业务层异常");
    private String var;

    Service(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
