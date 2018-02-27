package cn.blue.common.other;

public enum UserSession {
    USER_SESSION("user");
    private String var;

    UserSession(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
