package cn.blue.jk.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Description:　Created by IntelliJ IDEA
 * @Author: zhou
 * @Company:
 * @CreateDate: 18-1-31
 * table packing_list_c
 */
public class PackingList implements Serializable {
    private String id;
    private String seller;        //卖方
    private String buyer;        //买方
    private String invoiceNo;    //发票号
    private Date invoiceDate;        //发票日期
    private String marks;        //唛头
    private String descriptions;    //描述

    private String exportIds;        //存储报运的id的串
    private String exportNos;        //存储报运号

    private Integer state;        //状态0草稿 1已上报

    private String createBy;
    private String createDept;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getExportIds() {
        return exportIds;
    }

    public void setExportIds(String exportIds) {
        this.exportIds = exportIds;
    }

    public String getExportNos() {
        return exportNos;
    }

    public void setExportNos(String exportNos) {
        this.exportNos = exportNos;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PackingList(String id) {
        this.id = id;
    }

    public PackingList() {
    }

    @Override
    public String toString() {
        return "PackingList{" +
                "id='" + id + '\'' +
                ", seller='" + seller + '\'' +
                ", buyer='" + buyer + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", marks='" + marks + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", exportIds='" + exportIds + '\'' +
                ", exportNos='" + exportNos + '\'' +
                ", state=" + state +
                ", createBy='" + createBy + '\'' +
                ", createDept='" + createDept + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
