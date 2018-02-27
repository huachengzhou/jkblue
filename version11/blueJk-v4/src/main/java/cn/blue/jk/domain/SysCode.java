package cn.blue.jk.domain;

import java.io.Serializable;

/**
 * @Description:　Created by IntelliJ IDEA
 * @Author: zhou
 * @Company:
 * @CreateDate: 18-1-31
 * 字典
 */
public class SysCode implements Serializable {
    private String id;
    private Integer orderNo;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysCode{" +
                "id='" + id + '\'' +
                ", orderNo=" + orderNo +
                ", name='" + name + '\'' +
                '}';
    }

    public SysCode() {
    }
}
