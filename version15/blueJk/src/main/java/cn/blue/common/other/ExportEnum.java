package cn.blue.common.other;

public enum ExportEnum {
    EXPORT_ENUM_Start("1"), EXPORT_ENUM_END("0");
    private String var;

    ExportEnum(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
