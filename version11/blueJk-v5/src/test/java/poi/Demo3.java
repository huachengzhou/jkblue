package poi;

import cn.blue.jk.service.OutProductService;
import cn.blue.jk.vo.OutProductVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class Demo3 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String path = "/home/zhou/";//workbookA.xls
    private OutProductService outProductService = null;

    @Test
    public void out() throws Exception {
        File file = new File(path + "tOUTPRODUCT.xlsx");
        InputStream is = new FileInputStream(file);
        Workbook wb = new XSSFWorkbook(is);            //打开一个模板文件，工作簿 2007以上版本
        Sheet sheet = wb.getSheetAt(0);            //获取到第一个工作表
        Row nRow = null;
        Cell nCell = null;
        int rowNo = 0;     //行号
        int colNo = 1;   //列号
        //获取模板上的单元格样式
        nRow = sheet.getRow(2);

        //客户的样式
        nCell = nRow.getCell(1);
        CellStyle customStyle = nCell.getCellStyle();

        //订单号的样式
        nCell = nRow.getCell(2);
        CellStyle contractNoStyle = nCell.getCellStyle();

        //货号的样式
        nCell = nRow.getCell(3);
        CellStyle productNoStyle = nCell.getCellStyle();

        //数量的样式
        nCell = nRow.getCell(4);
        CellStyle numStyle = nCell.getCellStyle();

        //生产厂家的样式
        nCell = nRow.getCell(5);
        CellStyle factoryStyle = nCell.getCellStyle();

        //日期的样式
        nCell = nRow.getCell(6);
        CellStyle dateStyle = nCell.getCellStyle();

        //贸易条款的样式
        nCell = nRow.getCell(8);
        CellStyle tradeStyle = nCell.getCellStyle();

        //头标题
        nRow = sheet.createRow(rowNo++);
        nCell = nRow.createCell(1);
        nCell.setCellValue("2018"+ UUID.randomUUID().toString());
        CellStyle headStyle = wb.createCellStyle();
        headStyle = bigTitleStyle(wb);
        nCell.setCellStyle(headStyle);

        //标题列
        CellStyle titleStyle = titleStyle(wb);
        String[] titles = {"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};
        nRow = sheet.createRow(rowNo++);
        for (int i = 0; i < titles.length; i++) {
            nCell = nRow.createCell(i+1);
            nCell.setCellValue(titles[i]);
            nCell.setCellStyle(titleStyle);
        }


        //处理内容
        List<OutProductVO> dataList = outProductService.outProducts("2018");
        for(int j=0;j<dataList.size();j++){
            colNo = 1;				//初始化
            OutProductVO op = dataList.get(j);

            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCustomName());
            nCell.setCellStyle(customStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getContractNo());
            nCell.setCellStyle(contractNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getProductNo());
            nCell.setCellStyle(productNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCnumber());
            nCell.setCellStyle(numStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getFactoryName());
            nCell.setCellStyle(factoryStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getDeliveryPeriod());
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getShipTime());
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getTradeTerms());
            nCell.setCellStyle(tradeStyle);
        }
        FileOutputStream outputStream = new FileOutputStream(path+"出货表.xlsx");
        wb.write(outputStream);
        logger.info("end!");
    }

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        outProductService = context.getBean(OutProductService.class);
    }

    //小标题样式
    private CellStyle titleStyle(Workbook wb){
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        curFont.setFontName("黑体");
        curFont.setFontHeightInPoints((short)12);

        curStyle.setFont(curFont);										//绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中


        curStyle.setBorderTop(CellStyle.BORDER_THIN);					//设置四周边线，细线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);
        curStyle.setBorderLeft(CellStyle.BORDER_THIN);
        curStyle.setBorderRight(CellStyle.BORDER_THIN);

        return curStyle;
    }

    //大标题样式
    private CellStyle bigTitleStyle(Workbook wb){
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        curFont.setFontName("宋体");
        curFont.setFontHeightInPoints((short)16);
        curFont.setBoldweight(Font.BOLDWEIGHT_BOLD);					//字体加粗

        curStyle.setFont(curFont);										//绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        return curStyle;
    }
}
