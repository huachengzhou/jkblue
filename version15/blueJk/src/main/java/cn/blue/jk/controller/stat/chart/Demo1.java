package cn.blue.jk.controller.stat.chart;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

public class Demo1 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取当前类的绝对路径
     */
    @Test
    public void pathTest(){
        File file = new File(this.getClass().getResource("").getPath());
        logger.info(file+"");
    }

    /**
     * 获取当前src下面的文件的路径
     */
    @Test
    public void fun4() {
        String path = this.getClass().getClassLoader().getResource("cn/blue/jk/controller/stat/chart/").getPath();
        System.out.println(path);

        File file = new File(path+"info.sql");
        if (file.isFile()){
            System.out.println("是一个file");
        }else {
            System.out.println("非file");
        }
    }

    /**
     * 获取其他源码包下面的文件路径
     */
    @Test
    public void fun5() {
        // 使用这种方法可以获取路径
        URL url = this.getClass().getClassLoader().getResource("/info.sql");
        // file:/D:/project/taotaoshop/src/blog-mybatis1/target/classes/test.txt
        System.out.println(url);
    }
}
