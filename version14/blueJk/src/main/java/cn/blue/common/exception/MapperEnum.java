package cn.blue.common.exception;

public enum MapperEnum {
    MAPPER_ENUM("mapper异常");
    private String var;


    MapperEnum(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
