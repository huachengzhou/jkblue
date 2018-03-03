package cn.blue.jk.domain;

import java.io.Serializable;

/**
 * @Description:　Created by IntelliJ IDEA
 * @Author: zhou
 * @Company:
 * @CreateDate: 18-1-31
 * 合同下附件
 * table ext_cproduct_c ext_cproduct_c
 * 一款货可对应多个附件，目前只有彩盒、花纸、保丽龙
 */
public class ExtCproduct implements Serializable {
    private String id;
    private String contractProductId;            //关联关系的表（外键），都成为普通字段
    private String factoryId;
    private String factoryName;
    private String ctype; //类型[系统下拉列表]
    private String productNo;
    private String productImage;
    private String productDesc;
    private Integer cnumber;//数量
    private String packingUnit;            //包装单位
    private Double price;
    private Double amount;//总金额
    private String productRequest;
    private Integer orderNo;//排序号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractProductId() {
        return contractProductId;
    }

    public void setContractProductId(String contractProductId) {
        this.contractProductId = contractProductId;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(String productRequest) {
        this.productRequest = productRequest;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "ExtCproduct{" +
                "id='" + id + '\'' +
                ", contractProductId='" + contractProductId + '\'' +
                ", factoryId='" + factoryId + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", ctype='" + ctype + '\'' +
                ", productNo='" + productNo + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", cnumber=" + cnumber +
                ", packingUnit='" + packingUnit + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", productRequest='" + productRequest + '\'' +
                ", orderNo=" + orderNo +
                '}';
    }

    public ExtCproduct() {
    }
}
