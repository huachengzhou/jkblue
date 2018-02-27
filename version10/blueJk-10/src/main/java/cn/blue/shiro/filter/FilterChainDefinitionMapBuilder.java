package cn.blue.shiro.filter;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        /*顺序不能有错*/
        map.put("/sys/login.action","anon");
        map.put("/index.jsp","anon");
        map.put("/pages/sys/login.jsp","anon");

        map.put("/home.action","anon");

        map.put("/**","authc");
        return map;
    }
}
