package cn.blue.jk.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.UUID;
@ComponentScan(basePackages = {"cn.blue.jk.util"})
@Component(value = "initData")
public class InitData {

    public String uuid() {
        return UUID.randomUUID().toString();
    }

}
