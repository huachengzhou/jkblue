package cn.blue.shiro.filter;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        /*顺序不能有错*/
        map.put("/sys/login.action","anon");
//        map.put("/sys/login.action","kickout,anon");//并发控制登录
        map.put("/index.jsp","anon");//起始view
        map.put("/pages/sys/login.jsp","anon");//登录

        map.put("/home.action","anon");//转到登录
        map.put("/getJPGCode.action","anon");//验证码

        map.put("/**","authc");
        return map;
    }
}
