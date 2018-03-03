package cn.blue.jk.domain.other;

import java.io.Serializable;

public class ContractB implements Serializable {
    private Integer sumnum;
    private String name;

    public Integer getSumnum() {
        return sumnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSumnum(Integer sumnum) {
        this.sumnum = sumnum;
    }
}
