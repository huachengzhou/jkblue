package me.spring;

import cn.blue.common.help.Zhou_StdRandom;
import cn.blue.jk.domain.ContractProduct;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.service.ContractProductService;
import cn.blue.jk.service.FactoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

public class ContractProductServiceTest {
    private Logger logger = Logger.getLogger("" + this);
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private ContractProductService service = null;
    private FactoryService factoryService = null;

    @Test
    public void get() throws Exception {
        String id = "4028817a3357462e01336d3a0be10019";
        ContractProduct contractProduct = service.get(id);
        logger.info(contractProduct + "");
    }

    @Test
    public void find() throws Exception {
        List<ContractProduct> contractProducts = service.find(null);
        contractProducts.stream().forEach((c) -> logger.info("" + c));
    }

    @Test
    public void update() throws Exception {
        String id = "4028817a3357462e0133591b86ec0003";
        ContractProduct contractProduct = service.get(id);
        contractProduct.setProductNo("3000");
        service.update(contractProduct);
        logger.info(contractProduct.getProductNo());
    }

    @Test
    public void insert() throws Exception {
        String id = new Random().nextBoolean()?"be03b359-0763-4f28-94f5-a2b2e6f19d0b":new Random().nextBoolean()?"24306846-79f9-4daf-8612-47adb2687f04":"33f80e0b-d9f9-465f-8d33-416140b29fd2";
        String contractId = new Random().nextBoolean()?"3e678779-657a-40d3-8215-9e78f2aab813":new Random().nextBoolean()?"7b183327-9e3c-4dd8-bb8b-3868b72217e8":"53557cf1-7530-42b7-921b-6519288f822a";
        Factory factory = factoryService.get(id);

        ContractProduct contractProduct = new ContractProduct();

        contractProduct.setFactoryId(factory.getId());
        contractProduct.setFactoryName(factory.getFactoryName());
        contractProduct.setExts("No specific instructions");
        contractProduct.setOrderNo(Zhou_StdRandom.uniform(10));
        contractProduct.setContractId(contractId);
        contractProduct.setProductImage("/home/zhou/ssh_java/config");
        contractProduct.setCnumber(Zhou_StdRandom.uniform(210, 20000));
        contractProduct.setOutNumber(0);
        contractProduct.setLoadingRate("1/3");
        contractProduct.setBoxNum(Zhou_StdRandom.uniform(200, 300));
        contractProduct.setPackingUnit(new Random().nextBoolean() ? "URT" : "POI");
        contractProduct.setPrice(new Random().nextDouble() * 10000);
//        contractProduct.setAmount(coninittractProduct.getPrice() * contractProduct.getBoxNum());
        contractProduct.setFinished(new Random().nextInt(1));
        contractProduct.setId(UUID.randomUUID().toString());
        contractProduct.setProductNo(""+Zhou_StdRandom.uniform(5200, 13000));
        String s1 = "全明料平光蛋糕罩配钻石盘子\t\n" +
                "罩子上粘小鸟，小鸟和钻石盘我司供\n" +
                "罩子尺寸：26X36CM高\t\t\n" +
                "1套/上下保利龙盖/内盒\t\t\n" +
                "2套/大箱\t\t\t\n" +
                "保利龙垫工厂供\n" +
                "产品用保丽龙包装后入内盒，大箱，大箱用胶带纸工字封口。";
        String s2 = "全明料冰花风灯粘电镀底座， \t\n" +
                "喷紫色，全喷，内电镀花银\t\n" +
                "尺寸：15.8X32CM高\t\t\n" +
                "1只/五层内盒     6只/五层大箱\n" +
                "产品用白纸，瓦楞纸，气泡纸包裹后入内盒，大箱，大箱用胶带纸工字封口";
        String s = new Random().nextBoolean()?s1:s2;
        contractProduct.setProductDesc(new Random().nextBoolean()?"\"nothing\"":s);
        service.insert(contractProduct);
        logger.info(contractProduct+"");
    }

    @Test
    public void delete()throws Exception{
        String[] ids = {"0e24c258-14cc-46e9-b891-f5952a9b3e2b","0257473b-2875-4400-b99a-b8e8b69772c9"};
        service.deleteById(ids[0]);
    }

    @Before
    public void init() {
        service = context.getBean(ContractProductService.class);
        factoryService = context.getBean(FactoryService.class);
    }
}
