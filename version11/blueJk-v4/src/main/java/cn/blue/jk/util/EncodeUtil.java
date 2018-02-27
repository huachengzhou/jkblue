package cn.blue.jk.util;

import java.net.URLDecoder;

public class EncodeUtil {
    public static String encode(String var) {
        String s = null;
        try {
            s = URLDecoder.decode(var, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
