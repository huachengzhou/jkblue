package cn.blue.jk.util;

import org.apache.commons.lang.StringUtils;

public class Demo1 {
    public static void main(String[] args) {
        String s1 = StringUtils.deleteWhitespace(
                "#{exportProductId},\n" +
                        "#{factoryId},\n" +
                        "#{factoryName},\n" +
                        "#{ctype},\n" +
                        "#{productNo},\n" +
                        "#{productImage},\n" +
                        "#{productDesc},\n" +
                        "#{cnumber},\n" +
                        "#{packingUnit},\n" +
                        "#{price},\n" +
                        "#{amount},\n" +
                        "#{productRequest},\n" +
                        "#{orderNo}"
        );
        System.out.println(s1);
    }
}
