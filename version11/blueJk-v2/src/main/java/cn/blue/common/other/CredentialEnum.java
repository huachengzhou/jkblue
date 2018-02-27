package cn.blue.common.other;

public enum CredentialEnum {
    SHA1("SHA1"),MD5("MD5");
    private String var;

    CredentialEnum(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
