package me.spring;

import cn.blue.common.help.Zhou_StdRandom;
import cn.blue.jk.domain.ContractProduct;
import cn.blue.jk.domain.ExtCproduct;
import cn.blue.jk.domain.Factory;
import cn.blue.jk.domain.SysCode;
import cn.blue.jk.exception.ServiceException;
import cn.blue.jk.service.ContractProductService;
import cn.blue.jk.service.ExtCproductService;
import cn.blue.jk.service.FactoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.logging.Logger;

public class ExtCproductServiceTest {
    private Logger logger = Logger.getLogger("" + this);
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private ExtCproductService extCproductService = null;

    @Test
    public void list() throws ServiceException {
        List<SysCode> list = extCproductService.findSysCode(null);
        list.stream().parallel().forEach((sysCode -> logger.info("" + sysCode)));
    }

    @Test
    public void find() throws ServiceException {
        Map<String, Object> map = new HashMap<>();
        map.put(ExtCproductService.contractProductId, "db61ead0-40d1-4a1b-bd11-61e371b17a46");
        List<ExtCproduct> extCproducts = extCproductService.find(map);
        extCproducts.stream().parallel().forEach((extCproduct -> logger.info("" + extCproduct)));
    }

    @Test
    public void remove()throws Exception{
        String[] ids = {"1cbe93ec-e103-41cf-a887-87e90c06b0d7","59ee4fb7-5922-4be8-a843-6f0b1a630fa9"};
        extCproductService.delete(ids);
    }

    @Test
    public void insert() throws ServiceException {
        Random random = new Random(System.currentTimeMillis());
        FactoryService factoryService = context.getBean(FactoryService.class);
        ContractProductService contractProductService = context.getBean(ContractProductService.class);
        ExtCproduct extCproduct = new ExtCproduct();

        Factory factory = factoryService.find(null).get(Zhou_StdRandom.uniform(0, factoryService.find(null).size()));
        ContractProduct contractProduct = contractProductService.find(null).get(Zhou_StdRandom.uniform(0, contractProductService.find(null).size()));

        extCproduct.setId(UUID.randomUUID().toString());
        extCproduct.setFactoryId(factory.getId());
        extCproduct.setFactoryName(factory.getFactoryName());
        extCproduct.setContractProductId(contractProduct.getId());
        extCproduct.setCtype("" + new Random(System.currentTimeMillis()).nextInt(4));
        extCproduct.setProductNo("" + Zhou_StdRandom.uniform(4000, 5000));
        extCproduct.setProductImage("undefined");
        extCproduct.setPackingUnit("PCS");
        extCproduct.setCnumber(Zhou_StdRandom.uniform(200, 1000));
        extCproduct.setProductRequest(random.nextBoolean() ? s1 : s2);
        extCproduct.setPrice(Zhou_StdRandom.uniform(2000, 4000.5));
        extCproduct.setAmount(Zhou_StdRandom.uniform(10000, 40000.5));
        extCproduct.setOrderNo(random.nextInt(400));
        extCproductService.insert(extCproduct);
        logger.info(extCproduct + "");
    }

    @Test
    public void update() throws Exception {
        String id = "59ee4fb7-5922-4be8-a843-6f0b1a630fa9";
        ExtCproduct extCproduct = extCproductService.get(id);
        extCproduct.setCtype("44");
        extCproductService.update(extCproduct);
    }

    @Before
    public void init() {
        extCproductService = (ExtCproductService) context.getBean("extCproductService");
    }

    String s2 = "1.产品的颜色、造型、尺寸、重量务必同我司封样一致；\n" +
            "2.工厂免费提供2% 余量，以防损耗，代用包装送至指定工厂；请在外包装上注明相对应的合同号及货号；\n" +
            "3.交期:2015年1月15日。";

    String s1 = "★   产品与封样无明显差异，唛头、标签及包装质量务必符合公司要求。 \n" +
            " ★★  产品生产前期、中期、后期抽验率不得少于10%，质量和封样一致， \n" +
            "       并将验货照片传回公司。 \n" +
            "★★★ 重点客人的质量标准检验，产品抽验率不得少于50%，务必做到入箱前检查。 \n" +
            " 交期：2015年2月15日/工厂。       没有经过我司同意无故延期交货造成严重后果的，按照客人的相关要求处理。 \n" +
            " 开票：出货后请将增值税发票、验货报告、合同复印件及出库单一并寄至我司，以便我司安排付款。";
}
