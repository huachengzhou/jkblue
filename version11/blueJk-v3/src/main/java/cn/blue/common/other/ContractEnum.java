package cn.blue.common.other;

public enum ContractEnum {
    CONTRACT_ENUM_submit("1"), CONTRACT_ENUM_cancel("0");
    private String var;

    ContractEnum(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
