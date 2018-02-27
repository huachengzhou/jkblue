package poi;

import cn.blue.jk.service.OutProductService;
import cn.blue.jk.vo.OutProductVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Demo2 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String path = "/home/zhou/";//workbookA.xls
    private OutProductService outProductService = null;

    @Test
    public void xls() throws IOException {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row = null;//第二行
        Cell cell = null;
        String[] titles = {"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};
        List<OutProductVO> voList = outProductService.outProducts(null);

        int rowNo = 0; //行号
        int celNo = 1;//列号

        sheet.setColumnWidth(0,19*22);//列的宽度
        for (int i = 0; i < titles.length; i++) {
            sheet.setColumnWidth(i+1,19*256);//列的宽度
        }

        //大标题合并
        sheet.addMergedRegion(new CellRangeAddress(0,0,1,titles.length+1));
        row = sheet.createRow(rowNo++);
        cell = row.createCell(1);
        cell.setCellValue("客户订单报表");//合并单元格的内容写在合并前第一个单元格
        CellStyle titleStyle = bigTitleStyle(wb);
        cell.setCellStyle(titleStyle);

        row = sheet.createRow(rowNo++);//标题行
        titleStyle = titleStyle(wb);
        for (int i = 0; i < titles.length; i++) {
            cell = row.createCell(i + 1);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(titleStyle);
        }

        CellStyle contentStyle = wb.createCellStyle();
        Font contentFont = wb.createFont();
        contentStyle = textStyle(wb,contentStyle,contentFont);
        //处理数据行
        for (int i = 0; i < voList.size(); i++) {
            OutProductVO vo = voList.get(i);
            row = sheet.createRow(rowNo++);
            if (celNo!=1)celNo = 1;//初始化　一行写完以后才调用
            for (int j = 0; j < titles.length; j++) {
                cell = row.createCell(celNo++);
                cell.setCellStyle(contentStyle);
                switch (j) {
                    case 0:
                        cell.setCellValue(vo.getCustomName());
                        break;
                    case 1:
                        cell.setCellValue(vo.getContractNo());
                        break;
                    case 2:
                        cell.setCellValue(vo.getProductNo());
                        break;
                    case 3:
                        cell.setCellValue(vo.getCnumber());
                        break;
                    case 4:
                        cell.setCellValue(vo.getFactoryName());
                        break;
                    case 5:
                        cell.setCellValue(vo.getShipTime());
                        break;
                    case 6:
                        cell.setCellValue(vo.getDeliveryPeriod());
                        break;
                    case 7:
                        cell.setCellValue(vo.getTradeTerms());
                        break;
                    default:
                        break;
                }
            }

        }

        FileOutputStream out = new FileOutputStream(path + "toutproduct.xls");
        wb.write(out);
        out.flush();
        out.close();
        logger.info("end!");
    }

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        outProductService = context.getBean(OutProductService.class);
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

    //文字样式
    private CellStyle textStyle(Workbook wb, CellStyle curStyle, Font curFont){

        curFont.setFontName("Times New Roman");
        curFont.setFontHeightInPoints((short)10);

        curStyle.setFont(curFont);										//绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中


        curStyle.setBorderTop(CellStyle.BORDER_THIN);					//设置四周边线，细线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);
        curStyle.setBorderLeft(CellStyle.BORDER_THIN);
        curStyle.setBorderRight(CellStyle.BORDER_THIN);

        return curStyle;
    }
}
