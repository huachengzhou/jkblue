package me.spring;

import cn.blue.common.help.ZhouCalendarUtil;
import cn.blue.common.help.Zhou_StdRandom;
import cn.blue.common.help.Zhou_String;
import cn.blue.common.help.Zhou_Word;
import cn.blue.jk.domain.Contract;
import cn.blue.jk.service.ContractService;
import cn.blue.jk.vo.ContractVO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

public class ContractServiceTest {
    private Logger logger = Logger.getLogger(toString());
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private ContractService service;

    @Test
    public void get() throws Exception {
        String id = "d3f8788e-054b-43fd-8f8b-84617a8e6fe2";
        ContractVO contract = service.view(id);
        contract.getContractProducts().forEach((contractProductVO -> System.out.println(contractProductVO.getProductImage())));
//        logger.info(contract + "");
    }

    @Test
    public void find() throws Exception {
        List<ContractVO> contractList = service.find(null);
        contractList.forEach((contract -> {
            contract.getContractProducts().stream().forEach((o) ->{
                System.out.println(o.getExtCproducts().size());
            });
        }));
    }

    @Test
    public void insertINTO()throws Exception{
        Contract contract = new Contract();
        contract.setId(UUID.randomUUID().toString());
        contract.setShipTime(new Date());
        contract.setImportNum(Zhou_StdRandom.uniform(1,5));
        contract.setCheckBy(Zhou_Word.getChineseName_Random());
        contract.setInputBy(Zhou_Word.getEnglishName());
        contract.setOfferor("陕西杰信商务发展有限公司");
        contract.setSigningDate(ZhouCalendarUtil.formate_(Zhou_StdRandom.uniform(2000,3000)+"-0"+Zhou_StdRandom.uniform(9)+"-"+Zhou_StdRandom.uniform(12,30)));//yyyy-MM-dd
        contract.setCreateTime(new Date());
        contract.setCreateDept("000100"+Zhou_String.toMath(2));
        contract.setCreateBy(Zhou_String.toLowerCase(20));
        contract.setOutState(Zhou_StdRandom.uniform(0,1));
        contract.setTradeTerms(Zhou_String.toUpperCase(2)+"/"+Zhou_String.toUpperCase(2));
        contract.setState(new Random().nextBoolean()?1:0);
        contract.setPrintStyle(Zhou_StdRandom.uniform(2)+"");
        contract.setCrequest("★   产品与封样无明显差异，唛头、标签及包装质量务必符合公司要求。 \n" +
                " ★★  产品生产前期、中期、后期抽验率不得少于10%，质量和封样一致， \n" +
                "       并将验货照片传回公司。 \n" +
                "★★★ 重点客人的质量标准检验，产品抽验率不得少于50%，务必做到入箱前检查。 \n" +
                " 交期：2012年2月15日/工厂。\n" +
                "       没有经过我司同意无故延期交货造成严重后果的，按照客人的相关要求处理。 \n" +
                " 开票：出货后请将增值税发票、验货报告、合同复印件及出库单一并寄至我司，以便我司安排付款。");
        contract.setTotalAmount(Zhou_StdRandom.uniform(10000.0,20000.0));
        contract.setInspector(Zhou_Word.getChineseName());
        contract.setRemark(new Random().nextBoolean()?"待样品确认后方可安排生产":"由于风险过高,需要请示上级部门才可生产");
        contract.setDeliveryPeriod(ZhouCalendarUtil.formate_("2016-03-22"));
        contract.setContractNo(Zhou_String.toUpperCase(2)+"/"+Zhou_String.toMath(4)+Zhou_String.toUpperCase(2));
        contract.setCustomName(new Random().nextBoolean()?"COACH HOUSE":"BEAKIE LEE");
        contract.setOldState(Zhou_StdRandom.uniform(0,4));
        service.insert(contract);
        System.out.println(contract);
    }

    @Test
    public void update()throws Exception{
//        for (int i = 0; i < 50; i++) {
//            insertINTO();
//        }
        String id = "08b4b6db-9884-4000-b6dd-7c1cd91e2d32";
        ContractVO contract = service.get(id);
        System.out.println(contract);
        contract.setCheckBy("张三");
//        service.update(contract);
//        System.out.println(contract.getCheckBy());
    }

    @Test
    public void remove()throws Exception{
//        String id = "08b4b6db-9884-4000-b6dd-7c1cd91e2d32";
//        service.deleteById(id);
        String[] ids = {"1823b2ef-f4bc-4765-8eba-01b1c1df03f5","14aa8541-7b34-4c97-bc76-4b6ef1512e0c","00e31138-778e-468a-b475-7aae84d2893d"};
        service.delete(ids);
    }

    @Test
    public void submit()throws Exception{
        String[] ids = {"186c9505-689c-4a6a-968d-51ab3da9b6ba"};
        service.submit(ids);
    }

    @Before
    public void init() {
        service = context.getBean(ContractService.class);
    }
}
