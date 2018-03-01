package poi;

import cn.blue.jk.service.ContractService;
import cn.blue.jk.util.poi.PoiUtil;
import cn.blue.jk.vo.ContractProductVO;
import cn.blue.jk.vo.ContractVO;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class Demo4 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String path = "/home/zhou/";//tCONTRACT.xlsx
    private ContractService contractService = null;

    @Test
    public void print() throws Exception {
//        ContractVO contract = contractService.view("d3f8788e-054b-43fd-8f8b-84617a8e6fe2");
        //相同厂家的信息一起打印
//        List<ContractProductVO> oList = contract.getContractProducts();
        File tempXlsFile = new File(path + "tCONTRACT.xls");
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
        for (int p = 0; p < 1; p++) {//假设有1页
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
//            nCell.setCellValue(printMap.get("Offeror"));//有数据就打开
            nCell.setCellValue("Offeror:");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));
            //Facotry
            nCell   = nRow.createCell((5));
//            nCell.setCellValue(printMap.get("Factory"));//有数据就打开
            nCell.setCellValue("Factory:");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

            //ContractNo  第八行
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(20);

            nCell   = nRow.createCell(1);
//            nCell.setCellValue(printMap.get("ContractNo")); //有数据就打开
            nCell.setCellValue("ContractNo:");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

            //Contractor
            nCell  = nRow.createCell(5);
//            nCell.setCellValue(printMap.get("Contractor"));//有数据就打开
            nCell.setCellValue("Contractor");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

            //SigningDate  第九行
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(20);

            nCell = nRow.createCell(1);
//            nCell.setCellValue(printMap.get("SigningDate"));//有数据就打开
            nCell.setCellValue("SigningDate:");
            nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

            //Phone
            nCell = nRow.createCell(5);
//            nCell.setCellValue(printMap.get("Phone"));//有数据就打开
            nCell.setCellValue("Phone:");
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
//            nCell.setCellValue(printMap.get("ContractDesc"));//有数据就打开
            nCell.setCellValue("ContractDesc");
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
                poiUtil.setPicture(wb, patriarch, path+"围裙.jpg", curRow-1, 1, curRow, 3);


                nCell = nRow.createCell(2);
                nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));

                nCell = nRow.createCell(3);
                nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));

                //ProductDesc
                region = new CellRangeAddress(curRow-1, curRow, 4, 4);	//纵向合并单元格
                sheet.addMergedRegion(region);

                nCell = nRow.createCell(4);
    //            nCell.setCellValue(printMap.get("ProductDesc"));//有数据再打开
                nCell.setCellValue("ProductDesc");
                nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));

                //Cnumber
                region = new CellRangeAddress(curRow-1, curRow, 5, 5);	//纵向合并单元格
                sheet.addMergedRegion(region);

                nCell = nRow.createCell(5);
                nCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
    //            nCell.setCellValue(Double.parseDouble(printMap.get("Cnumber")));//有数据再打开
                nCell.setCellValue(Double.parseDouble("4546"));
                nCell.setCellStyle(poiUtil.numberrv10_BorderThin(wb, defaultFont10));

                //Unit
                region = new CellRangeAddress(curRow-1, curRow, 6, 6);	//纵向合并单元格
                sheet.addMergedRegion(region);

                nCell = nRow.createCell(6);
    //            nCell.setCellValue(printMap.get("PackingUnit"));
                nCell.setCellValue("箱");
                nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));

                //Price
                region = new CellRangeAddress(curRow-1, curRow, 7, 7);	//纵向合并单元格
                sheet.addMergedRegion(region);

                nCell = nRow.createCell(7);
                nCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
    //            nCell.setCellValue(Double.parseDouble(printMap.get("Price")));//有数据再打开
                nCell.setCellValue(Double.parseDouble("4534534.4"));
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
    //            nCell.setCellValue(printMap.get("ProductNo"));
                nCell.setCellValue("33535443");;
                nCell.setCellStyle(poiUtil.notecv10_BorderThin(wb, defaultFont10));
                for(int j=2;j<9;j++){
                    nCell = nRow.createCell(j);
                    nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
                }
            }
            //InputBy
            nRow = sheet.createRow(curRow++);//假如样式只有１个　那么到13行
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(1);
//            nCell.setCellValue(printMap.get("InputBy"));
            nCell.setCellValue("InputBy");
            nCell.setCellStyle(poiUtil.bnormalv12(wb,defaultFont12));

            //CheckBy+inspector

            nCell = nRow.createCell(4);
//            nCell.setCellValue(printMap.get("CheckBy"));
            nCell.setCellValue("CheckBy");
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
            nRow = sheet.createRow(curRow++);
            nRow.setHeightInPoints(21);

            nCell = nRow.createCell(2);
//            nCell.setCellValue(printMap.get("Remark"));
            nCell.setCellValue("Remark");
            nCell.setCellStyle(noteStyle(wb));

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

        FileOutputStream outputStream = new FileOutputStream(path+"Test.xls");
        wb.write(outputStream);
        logger.info("end!");
    }

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        contractService = context.getBean(ContractService.class);
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

    public HSSFCellStyle thStyle(HSSFWorkbook wb) {
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

    public HSSFCellStyle bcv12(HSSFWorkbook wb) {
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
