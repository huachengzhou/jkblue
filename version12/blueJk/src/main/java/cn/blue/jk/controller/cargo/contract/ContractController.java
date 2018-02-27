package cn.blue.jk.controller.cargo.contract;

import cn.blue.common.view.VIEW;
import cn.blue.jk.controller.BaseController;
import cn.blue.jk.domain.Contract;
import cn.blue.jk.exception.ControllerException;
import cn.blue.jk.service.ContractService;
import cn.blue.jk.util.DownloadUtil;
import cn.blue.jk.util.EncodeUtil;
import cn.blue.jk.util.UtilFuns;
import cn.blue.jk.util.poi.PoiUtil;
import cn.blue.jk.vo.ContractProductVO;
import cn.blue.jk.vo.ContractVO;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * 购销合同 控制器
 *
 * @author zhou
 * Date: 18-2-8
 * Time: 下午4:55
 */
@Controller
public class ContractController extends BaseController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContractService contractService;

    @RequestMapping(value = "/cargo/contract/list.action")
    public String list(Map<String, Object> map) throws ControllerException,Exception {
        List<ContractVO> contractList = contractService.find(null);
        map.put("dataList", contractList);
        logger.info("/cargo/contract/list.action" + map);
        return VIEW.Pages.getVar() + "cargo/contract/jContractList" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contract/tocreate.action")
    public String toAddView()throws ControllerException{
        logger.info("/cargo/contract/tocreate.action");
        logger.info(VIEW.Pages.getVar() + "cargo/contract/jContractCreate" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "cargo/contract/jContractCreate" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contract/insert.action",method = RequestMethod.POST)
    public String toAdd(Contract contract)throws ControllerException,Exception{
        contract.setId(UUID.randomUUID().toString());

//        contract.setCustomName(EncodeUtil.encode(contract.getCustomName()));
//        contract.setCrequest(EncodeUtil.encode(contract.getCrequest()));
//        contract.setOfferor(EncodeUtil.encode(contract.getOfferor()));
//        contract.setRemark(EncodeUtil.encode(contract.getRemark()));

        contractService.insert(contract);
        logger.info("/insert.action");
        return  "redirect:/cargo/contract/list.action";
    }

    @RequestMapping(value = "/cargo/contract/toupdate.action")
    public String toUpdateView(Map<String, Object> map, @RequestParam(value = "id") String id)throws ControllerException,Exception{
        ContractVO contract = contractService.get(id);
        map.put("obj",contract);
        logger.info(contract+"");
        logger.info("/cargo/contract/toupdate.action");
        logger.info(VIEW.Pages.getVar() + "cargo/contract/jContractUpdate" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "cargo/contract/jContractUpdate" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contract/update.action")
    public String toUpdate(Contract contract)throws ControllerException,Exception{
        contractService.update(contract);
        logger.info("/cargo/contract/update.action");
        logger.info(""+contract);
        return  "redirect:/cargo/contract/list.action";
    }

    @RequestMapping(value = "/cargo/contract/delete.action")
    public String toRemove(@RequestParam(value = "id") String id)throws ControllerException,Exception{// 单个　和多个都可以删除
        String[] ids = id.split(",");
        contractService.delete(ids);
        logger.info("/cargo/contract/delete.action");
        logger.info("remove param:"+id);
        return  "redirect:/cargo/contract/list.action";
    }

    @RequestMapping(value = "/cargo/contract/toview.action")
    public String toView(@RequestParam(value = "id") String id,Map<String, Object> map)throws ControllerException,Exception{
        ContractVO contract = contractService.view(id);
        map.put("obj",contract);
        logger.info("/cargo/contract/toview.action");
        logger.info("param "+contract);
        logger.info(VIEW.Pages.getVar() + "cargo/contract/jContractView" + VIEW.JSP.getVar());
        return VIEW.Pages.getVar() + "cargo/contract/jContractView" + VIEW.JSP.getVar();
    }

    @RequestMapping(value = "/cargo/contract/submit.action")
    public String toSubmit(@RequestParam(value = "id") String id)throws ControllerException,Exception{
        String[] ids = id.split(",");
        contractService.submit(ids);
        logger.info("/cargo/contract/submit.action");
        logger.info("param "+ids);
        return  "redirect:/cargo/contract/list.action";
    }

    @RequestMapping(value = "/cargo/contract/cancel.action")
    public String toCancel(@RequestParam(value = "id") String id)throws ControllerException,Exception{
        String[] ids = id.split(",");
        contractService.cancel(ids);
        logger.info("/cargo/contract/cancel.action");
        logger.info("param "+ids);
        return  "redirect:/cargo/contract/list.action";
    }

    @RequestMapping(value = "/cargo/contract/print.action")
    public ResponseEntity<byte[]> print(@RequestParam(value = "id") String id, HttpServletRequest request, HttpServletResponse response){
        String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
        String pathA  = request.getSession().getServletContext().getRealPath("/");
        ResponseEntity<byte[]> responseEntity = null;
        try {
            logger.info(id);
            if (id!=null){
                ByteArrayOutputStream byteArray = printUtil(id,path,pathA);
                String fileName = UUID.randomUUID().toString() + ".xls";
                responseEntity = new DownloadUtil().createResponse(fileName, byteArray.toByteArray());
            }
        }catch (Exception e){
            logger.error("异常了 "+e.getMessage());
            e.printStackTrace();
        }
        return  responseEntity;
    }

    public ByteArrayOutputStream printUtil(String id,String path,String pathA)throws Exception{
        ContractVO contract = contractService.view(id);
        //相同厂家的信息一起打印
        List<ContractProductVO> oList = contract.getContractProducts();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024 * 2);
        File tempXlsFile = new File(path + "tCONTRACT.xls");
        //填写每页的内容，之后在循环每页读取打印
        Map<String,String> pageMap = null;
        List<Map> pageList = new ArrayList();			//打印页
        ContractProductVO oProduct = null;
        UtilFuns utilFuns = new UtilFuns();
        String stars = "";
        for(int j=0;j<contract.getImportNum();j++){		//重要程度
            stars += "★";
        }
        //-------------------
        String oldFactory = "";
        for(int i=0;i<oList.size();i++){
            if (i<0)break;
            oProduct = oList.get(i);	//获得货物
            try {
                pageMap = new HashMap();	//每页的内容
                pageMap.put("Offeror", "收 购 方：" + contract.getOfferor());
                System.out.println("oProduct"+oProduct);
                pageMap.put("Factory", "生产工厂：" + oProduct.getFactory().getFactoryName());
                pageMap.put("ContractNo", "合 同 号：" + contract.getContractNo());
                pageMap.put("Contractor", "联 系 人：" + oProduct.getFactory().getInspector());
                pageMap.put("SigningDate", "签单日期："+ UtilFuns.formatDateTimeCN(UtilFuns.dateTimeFormat(contract.getSigningDate())));
                pageMap.put("Phone", "电    话：" + oProduct.getFactory().getPhone());
                pageMap.put("InputBy", "制单：" + contract.getInputBy());
                pageMap.put("CheckBy", "审单："+ utilFuns.fixSpaceStr(contract.getCheckBy(),26)+"验货员："+utilFuns.convertNull(contract.getInspector()));
                pageMap.put("Remark", "  "+contract.getRemark());
                pageMap.put("Request", "  "+contract.getCrequest());

                pageMap.put("ProductImage", oProduct.getProductImage());
                pageMap.put("ProductDesc", oProduct.getProductDesc());
                pageMap.put("Cnumber", String.valueOf(oProduct.getCnumber().doubleValue()));
                if(oProduct.getPackingUnit().equals("PCS")){
                    pageMap.put("PackingUnit", "只");
                }else if(oProduct.getPackingUnit().equals("SETS")){
                    pageMap.put("PackingUnit", "套");
                }
                pageMap.put("Price", String.valueOf(oProduct.getPrice().doubleValue()));
                pageMap.put("ProductNo", oProduct.getProductNo());
                oldFactory = oProduct.getFactory().getFactoryName();
                if(contract.getPrintStyle().equals("2")){
                    i++;	//读取第二个货物信息
                    if(i<oList.size()){
                        if (i<0)break;
                        oProduct = oList.get(i);
                        try {//start 补丁判断 java.lang.NullPointerException
                            if(oProduct.getFactory().getFactoryName().equals(oldFactory)){	//厂家不同另起新页打印，除去第一次的比较
                                pageMap.put("ProductImage2", oProduct.getProductImage());
                                pageMap.put("ProductDesc2", oProduct.getProductDesc());
                                pageMap.put("Cnumber2", String.valueOf(oProduct.getCnumber().doubleValue()));
                                if(oProduct.getPackingUnit().equals("PCS")){
                                    pageMap.put("PackingUnit2", "只");
                                }else if(oProduct.getPackingUnit().equals("SETS")){
                                    pageMap.put("PackingUnit2", "套");
                                }
                                pageMap.put("Price2", String.valueOf(oProduct.getPrice().doubleValue()));
                                //pageMap.put("Amount2", String.valueOf(oProduct.getAmount().doubleValue()));			//在excel中金额采用公式，所以无需准备数据
                                pageMap.put("ProductNo2", oProduct.getProductNo());
                            }else{
                                i--;	//tip:list退回
                            }

                        }catch (NullPointerException e){
                            logger.error("看你还来不来!"+e.getLocalizedMessage());
                        }//end
                    }else{
                        pageMap.put("ProductNo2", null);	//后面依据此判断是否有第二个货物
                    }
                }
                pageMap.put("ContractDesc", stars+" 货物描述");			//重要程度 + 货物描述
                pageList.add(pageMap);

            }catch (NullPointerException e){
                logger.error("异常啦!"+e.getLocalizedMessage());
            }
        }
        //-------------------

        PoiUtil poiUtil = new PoiUtil();
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(tempXlsFile));    //打开excel文件
        HSSFFont defaultFont10 = poiUtil.defaultFont10(wb);        //设置字体
        HSSFFont defaultFont12 = poiUtil.defaultFont12(wb);        //设置字体
        HSSFFont blackFont = poiUtil.blackFont12(wb);            //设置字体
        Short rmb2Format = poiUtil.rmb2Format(wb);                //设置格式
        Short rmb4Format = poiUtil.rmb4Format(wb);                //设置格式

        HSSFSheet sheet = wb.getSheetAt(0);                //选择第一个工作簿
        wb.setSheetName(0, "购销合同");                //设置工作簿的名称

        CellRangeAddress region = null;
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();        //add picture

        HSSFRow nRow = null;
        HSSFCell nCell = null;
        int curRow = 0;
        //打印每页
        Map<String,String> printMap = null;
        for (int p = 0; p < pageList.size(); p++) {//假设有size页 找到bug了
            if(p>0){
                sheet.setRowBreak(curRow++);	//在第startRow行设置分页符
            }
            System.out.println("index:"+oList.size());
            printMap = pageList.get(p);
            //设置logo图片
            poiUtil.setPicture(wb, patriarch, path + "logo.jpg", curRow, 2, curRow + 4, 2);

            //header
            nRow = sheet.createRow(curRow++);//第一行
            nRow.setHeightInPoints(21);

            nCell = nRow.createCell((3));//第一行设置内容
            nCell.setCellValue("SHAANXI");
            nCell.setCellStyle(headStyle(wb));

            //header
            nRow = sheet.createRow(curRow++);//第二行
            nRow.setHeightInPoints(41);

            nCell = nRow.createCell((3));//第二行内容
            nCell.setCellValue("     JK INTERNATIONAL ");
            nCell.setCellStyle(tipStyle(wb));

            nRow = sheet.createRow(curRow++);//第三行
            nRow.setHeightInPoints(20);

            nCell   = nRow.createCell((2));//第三行内容
            nCell.setCellValue("                 西经济技术开发区西城一路27号无迪大厦19楼");
            nCell.setCellStyle(addressStyle(wb));
            //header
            nCell   = nRow.createCell((6));
            nCell.setCellValue(" CO., LTD.");
            nCell.setCellStyle(ltdStyle(wb));

            //header
            nRow = sheet.createRow(curRow++);//第四行
            nRow.setHeightInPoints(15);

            nCell   = nRow.createCell((2));
            nCell.setCellValue("                   TEL: 0086-29-86339371  FAX: 0086-29-86303310               E-MAIL: ijackix@glass.cn");
            nCell.setCellStyle(telStyle(wb));

            //line    第五行
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(7);
            poiUtil.setLine(wb, patriarch, curRow, 2, curRow, 8);	//draw line

            //header 第六行
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(30);

            nCell   = nRow.createCell((4));
            nCell.setCellValue("    购   销   合   同");
            nCell.setCellStyle(titleStyle(wb));

            //Offeror  第七行
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(20);

            nCell   = nRow.createCell((1));
            nCell.setCellValue(printMap.get("Offeror"));//有数据就打开
//            nCell.setCellValue("Offeror:");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));
            //Facotry
            nCell   = nRow.createCell((5));
            nCell.setCellValue(printMap.get("Factory"));//有数据就打开
//            nCell.setCellValue("Factory:");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

            //ContractNo  第八行
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(20);

            nCell   = nRow.createCell(1);
            nCell.setCellValue(printMap.get("ContractNo")); //有数据就打开
//            nCell.setCellValue("ContractNo:");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

            //Contractor
            nCell  = nRow.createCell(5);
            nCell.setCellValue(printMap.get("Contractor"));//有数据就打开
//            nCell.setCellValue("Contractor");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

            //SigningDate  第九行
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(20);

            nCell = nRow.createCell(1);
            nCell.setCellValue(printMap.get("SigningDate"));//有数据就打开
//            nCell.setCellValue("SigningDate:");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

            //Phone
            nCell = nRow.createCell(5);
            nCell.setCellValue(printMap.get("Phone"));//有数据就打开
//            nCell.setCellValue("Phone:");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

            //importNum
            nRow = sheet.createRow(curRow++);   //第10行
            nRow.setHeightInPoints(24);
            region = new CellRangeAddress(curRow-1, curRow-1, 1, 3);	//纵向合并单元格
            sheet.addMergedRegion(region);
            nCell = nRow.createCell(1);
            nCell.setCellValue("产品");
            nCell.setCellStyle(thStyle(wb));
            nCell = nRow.createCell(2);
            nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
            nCell = nRow.createCell(3);
            nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
            /*这里的列1-3都要设置相应的属性否则打印会出问题*/

            nCell = nRow.createCell(4);
            nCell.setCellValue(printMap.get("ContractDesc"));//有数据就打开
//            nCell.setCellValue("ContractDesc");
            nCell.setCellStyle(thStyle(wb));

            region = new CellRangeAddress(curRow-1, curRow-1, 5, 6);	//纵向合并单元格
            sheet.addMergedRegion(region);
            nCell = nRow.createCell(5);
            nCell.setCellValue("数量");
            nCell.setCellStyle(thStyle(wb));
            nCell = nRow.createCell(6);
            nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));

            nCell = nRow.createCell(7);
            nCell.setCellValue("单价");
            nCell.setCellStyle(thStyle(wb));
            nCell = nRow.createCell(8);
            nCell.setCellValue("总金额");
            nCell.setCellStyle(thStyle(wb));
            //
            for (int i = 0;i<1;i++){//假设只有１个样式
                nRow = sheet.createRow(curRow++); //第11行
                nRow.setHeightInPoints(96);

                region = new CellRangeAddress(curRow-1, curRow-1, 1, 3);	//纵向合并单元格
                sheet.addMergedRegion(region);
                //插入产品图片
                System.out.println(printMap.get(pathA+"ProductImage"));
                if (printMap.get("ProductImage")!=null&&printMap.get("ProductImage").length()>0){
                    poiUtil.setPicture(wb, patriarch, pathA+""+printMap.get("ProductImage"), curRow-1, 1, curRow, 3);
                }

                nCell = nRow.createCell(2);
                nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));

                nCell = nRow.createCell(3);
                nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));

                //ProductDesc
                region = new CellRangeAddress(curRow-1, curRow, 4, 4);	//纵向合并单元格
                sheet.addMergedRegion(region);

                nCell = nRow.createCell(4);
                nCell.setCellValue(printMap.get("ProductDesc"));//有数据再打开
//                nCell.setCellValue("ProductDesc");
                nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));

                //Cnumber
                region = new CellRangeAddress(curRow-1, curRow, 5, 5);	//纵向合并单元格
                sheet.addMergedRegion(region);

                nCell = nRow.createCell(5);
                nCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                nCell.setCellValue(Double.parseDouble(printMap.get("Cnumber")));//有数据再打开
//                nCell.setCellValue(Double.parseDouble("4546"));
                nCell.setCellStyle(poiUtil.numberrv10_BorderThin(wb, defaultFont10));

                //Unit
                region = new CellRangeAddress(curRow-1, curRow, 6, 6);	//纵向合并单元格
                sheet.addMergedRegion(region);

                nCell = nRow.createCell(6);
                nCell.setCellValue(printMap.get("PackingUnit"));
//                nCell.setCellValue("箱");
                nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));

                //Price
                region = new CellRangeAddress(curRow-1, curRow, 7, 7);	//纵向合并单元格
                sheet.addMergedRegion(region);

                nCell = nRow.createCell(7);
                nCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                nCell.setCellValue(Double.parseDouble(printMap.get("Price")));//有数据再打开
//                nCell.setCellValue(Double.parseDouble("4534534.4"));
                nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));


                //Amount
                region = new CellRangeAddress(curRow-1, curRow, 8, 8);	//纵向合并单元格
                sheet.addMergedRegion(region);
                nCell = nRow.createCell(8);
                if (true){
                    nCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                    nCell.setCellFormula("F"+String.valueOf(curRow)+"*H"+String.valueOf(curRow));//这里是一个excel求和
                }
                nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));

                curRow++;  //第１２行

                region = new CellRangeAddress(curRow-1, curRow-1, 1, 3);	//纵向合并单元格
                sheet.addMergedRegion(region);

                //ProductNo
                nRow = sheet.createRow(curRow-1);
                nRow.setHeightInPoints(24);

                nCell = nRow.createCell(1);
                nCell.setCellValue(printMap.get("ProductNo"));
//                nCell.setCellValue("33535443");;
                nCell.setCellStyle(poiUtil.notecv10_BorderThin(wb, defaultFont10));
                for(int j=2;j<9;j++){
                    nCell = nRow.createCell(j);
                    nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
                }
            }
            if(contract.getPrintStyle().equals("2") && UtilFuns.isNotEmpty(printMap.get("ProductNo2"))){
                System.out.println("是否存在样式２");
            }
            //InputBy
            nRow = sheet.createRow(curRow++);//假如样式只有１个　那么到13行
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(1);
            nCell.setCellValue(printMap.get("InputBy"));
//            nCell.setCellValue("InputBy");
            nCell.setCellStyle(poiUtil.bnormalv12(wb,defaultFont12));

            //CheckBy+inspector

            nCell = nRow.createCell(4);
            nCell.setCellValue(printMap.get("CheckBy"));
//            nCell.setCellValue("CheckBy");
            nCell.setCellStyle(poiUtil.bnormalv12(wb,defaultFont12));

            nCell = nRow.createCell(7);
            nCell.setCellValue("总金额：");
            nCell.setCellStyle(bcv12(wb));

            //TotalAmount
            if (true){
                nCell  = nRow.createCell(8);
                nCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                nCell.setCellFormula("SUM(I"+String.valueOf(curRow-4)+":I"+String.valueOf(curRow-1)+")");
                nCell.setCellStyle(poiUtil.moneyrv12_BorderThin(wb,defaultFont12,rmb2Format));
            }

            //note
//            nRow = sheet.createRow(curRow++);
//            nRow.setHeightInPoints(21);
//            nCell = nRow.createCell(2);
//            nCell.setCellValue(printMap.get("Remark"));
//            nCell.setCellStyle(noteStyle(wb));

            nRow = sheet.createRow(curRow++);
            //Request
            region = new CellRangeAddress(curRow-1, curRow, 1, 8);	//指定合并区域
            sheet.addMergedRegion(region);
            /*----------------------------------------------*/
            //space line
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(20);

            //duty
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(32);

            nCell = nRow.createCell(1);
            nCell.setCellValue("未按以上要求出货而导致客人索赔，由供方承担。");
            nCell.setCellStyle(dutyStyle(wb));

            //space line
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(32);

            //buyer
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(25);

            nCell = nRow.createCell(1);
            nCell.setCellValue("    收购方负责人：");
            nCell.setCellStyle(dutyStyle(wb));

            //seller
            nCell = nRow.createCell(5);
            nCell.setCellValue("供方负责人：");
            nCell.setCellStyle(dutyStyle(wb));

            curRow++;
        }
        wb.write(outputStream);
        return outputStream;
    }
    private HSSFCellStyle leftStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        curStyle.setWrapText(true);                        //换行
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置
        //fTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//加粗
        curFont.setFontHeightInPoints((short) 10);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);                //实线右边框
        curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);                //实线右边框

        return curStyle;
    }

    private HSSFCellStyle headStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("Comic Sans MS");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setItalic(true);
        curFont.setFontHeightInPoints((short) 16);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle tipStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("Georgia");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 28);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle addressStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        //fTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//加粗
        curFont.setFontHeightInPoints((short) 10);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle ltdStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("Times New Roman");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setItalic(true);
        curFont.setFontHeightInPoints((short) 16);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle telStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        //fTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//加粗
        curFont.setFontHeightInPoints((short) 9);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle titleStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("黑体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 18);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle requestStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        curStyle.setWrapText(true);                        //换行
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setFontHeightInPoints((short) 10);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle dutyStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("黑体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 16);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle noteStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 12);
        curStyle.setFont(curFont);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle thStyle(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                    //设置字体
        curFont.setFontName("宋体");
        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    //加粗
        curFont.setFontHeightInPoints((short) 12);
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);        //设置中文字体，那必须还要再对单元格进行编码设置

        curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);                //实线右边框
        curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);                //实线右边框
        curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);            //实线右边框
        curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);                //实线右边框

        curStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }

    private HSSFCellStyle bcv12(HSSFWorkbook wb) {
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();                        //设置字体
        curFont.setFontName("Times New Roman");
        curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);            //设置中文字体，那必须还要再对单元格进行编码设置

        curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);        //加粗
        curFont.setFontHeightInPoints((short) 12);
        curStyle.setFont(curFont);

        curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);                //实线
        curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);            //粗实线
        curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);            //实线
        curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);                //实线

        curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);        //单元格垂直居中

        return curStyle;
    }
}
