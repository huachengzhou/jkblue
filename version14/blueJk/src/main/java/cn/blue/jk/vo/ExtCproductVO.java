package cn.blue.jk.vo;

import cn.blue.jk.domain.ContractProduct;
import cn.blue.jk.domain.Factory;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhou
 * @Company:
 * @CreateDate: 2018年1月11日
 * 合同下附件
 * table ext_cproduct_c ext_cproduct_c
 * 一款货可对应多个附件，目前只有彩盒、花纸、保丽龙
 */
public class ExtCproductVO implements Serializable {
    private String id;

    private ContractProduct contractProduct;
    private Factory factory;

    private String ctype;//类型[系统下拉列表]
    private String productNo;//货号
    private String productImage;//货物照片
    private String productDesc;//货物描述
    private Integer cnumber;//数量
    private String packingUnit;            //包装单位
    private Double price; //单价
    private Double amount;//总金额
    private String productRequest;
    private Integer orderNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        double a1 = getPrice();
        double a2 = getCnumber();
        return a1 * a2;
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

    public ContractProduct getContractProduct() {
        return contractProduct;
    }

    public void setContractProduct(ContractProduct contractProduct) {
        this.contractProduct = contractProduct;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

}
