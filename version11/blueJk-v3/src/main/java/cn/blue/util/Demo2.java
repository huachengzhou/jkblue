package cn.blue.util;

import org.apache.shiro.codec.Base64;

public class Demo2 {
    public static void main(String[] args) throws Exception {
        String s = "hmFLUs0KTA3Kprsd";
        byte[] bs = Base64.encode(s.getBytes());
        s = new String(bs);
        System.out.println(s);
        bs = Base64.decode(s.getBytes());
        System.out.println(new String(bs));
    }
}
