package cn.blue.jk.domain.other;

import java.io.Serializable;

public class BarGraphFactory implements Serializable {
    private String fName;
    private String fId;
    private Integer fNumber;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public Integer getfNumber() {
        return fNumber;
    }

    public void setfNumber(Integer fNumber) {
        this.fNumber = fNumber;
    }

    @Override
    public String toString() {
        return "BarGraphFactory{" +
                "fName='" + fName + '\'' +
                ", fId='" + fId + '\'' +
                ", fNumber=" + fNumber +
                '}';
    }
}
