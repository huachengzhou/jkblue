package cn.blue.common.view;

public enum VIEW {
    VIEWS("view/"), JSP(".jsp"), Pages("pages/");
    private String var;

    VIEW(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
