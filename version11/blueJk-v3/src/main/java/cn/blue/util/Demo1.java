package cn.blue.util;

import org.springframework.util.Base64Utils;

import java.io.FileOutputStream;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        isit();
    }

    public static void isit() throws Exception {
        FileOutputStream DFHHD;//ctrl+space变量提示 ctrl+shift+u大小写切换

        String uuid = "d0bbfef6";
        System.out.println(uuid);
        byte[] bytes = Base64Utils.encode(uuid.getBytes("UTF-8"));
        uuid = new String(bytes, "UTF-8");
        System.out.println(uuid);
    }
}
