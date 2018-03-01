package cn.blue.jk.vo;

import cn.blue.jk.domain.Contract;
import cn.blue.jk.domain.Factory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zhou
 * @Company:
 * @CreateDate: 2018年1月11日
 * name 合同下货物
 * table contract_product_c
 */
public class ContractProductVO implements Serializable {
    private String id;

    private Contract contract;        //将复杂的关联关系变成单表操作
    private List<ExtCproductVO> extCproducts = new ArrayList<>();        //和附件一对多
    private Factory factory;        //和生产厂家多对一

    private String productNo;
    private String productImage;
    private String productDesc;
    private Integer cnumber; //数量
    private Integer outNumber;
    private String loadingRate;            //装率
    private Integer boxNum;                //箱数
    private String packingUnit;            //包装单位
    private Double price;    //单价
    private Double amount; //总金额
    private Integer finished; //是否出货完毕
    private String exts;
    private Integer orderNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<ExtCproductVO> getExtCproducts() {
        return extCproducts;
    }

    public void setExtCproducts(List<ExtCproductVO> extCproducts) {
        this.extCproducts = extCproducts;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
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

    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }

    public String getLoadingRate() {
        return loadingRate;
    }

    public void setLoadingRate(String loadingRate) {
        this.loadingRate = loadingRate;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
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
        return getPrice()*getCnumber();
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "ContractProductVO{" +
                "id='" + id + '\'' +
                ", contract=" + contract +
                ", extCproducts=" + extCproducts +
                ", factory=" + factory +
                ", productNo='" + productNo + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", cnumber=" + cnumber +
                ", outNumber=" + outNumber +
                ", loadingRate='" + loadingRate + '\'' +
                ", boxNum=" + boxNum +
                ", packingUnit='" + packingUnit + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", finished=" + finished +
                ", exts='" + exts + '\'' +
                ", orderNo=" + orderNo +
                '}';
    }
}
