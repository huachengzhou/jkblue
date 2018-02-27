package cn.blue.jk.util;

import org.apache.commons.lang.StringUtils;

public class Demo1 {
    public static void main(String[] args) {
        String s1 = StringUtils.deleteWhitespace("ID,INPUT_DATE,EPNUM, extnum, contractIds, customerContract, lcno, consignee, marks, remark, shipmentPort, destinationPort, transportMode, priceCondition, state, grossWeight, netWeight, measurement, createBy, createDept, createTime");
        System.out.println(s1);
    }
}
