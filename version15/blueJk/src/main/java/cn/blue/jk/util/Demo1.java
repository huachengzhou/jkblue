package cn.blue.jk.util;

import org.apache.commons.lang.StringUtils;

public class Demo1 {
    public static void main(String[] args) {
        String s1 = StringUtils.deleteWhitespace(
                "#{id},\n" +
                        "#{seller}, \n" +
                        "#{buyer}, \n" +
                        "#{invoiceNo}, \n" +
                        "#{invoiceDate},    \n" +
                        "#{marks},     \n" +
                        "#{descriptions},   \n" +
                        "\n" +
                        "#{exportIds},       \n" +
                        "#{exportNos},      \n" +
                        "\n" +
                        "#{state},        \n" +
                        "\n" +
                        "#{createBy},\n" +
                        "#{createDept},\n" +
                        "#{createTime}"
        );
        System.out.println(s1);
    }
}
