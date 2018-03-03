package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String path = "/home/zhou/ssh_java/config/excel/";//workbookA.xls

    /**
     * HSSFWorkbook 操作２００３以下版本
     *
     * @throws IOException
     * @throws Exception
     */
    @Test
    public void hssf() throws IOException, Exception {
        //1:创建一个工作薄
        Workbook workbook = new HSSFWorkbook();
        //2:创建一个工作表
        Sheet sheet = workbook.createSheet();//默认名字
        //3:创建一个行对象
        Row nrow = sheet.createRow(5 - 1);//第五行　坐标从0开始
        //4:创建单元格　并且指定列
        Cell cell = nrow.createCell(6 - 1);//第六列　坐标依然是从０开始
        //5:给单元格设置内容
        cell.setCellValue("好好学习,天天向上!");

        FileOutputStream out = new FileOutputStream(path + "workbookA.xls");
        workbook.write(out);
        out.flush();
        out.close();
        logger.info("end!");
    }

    /**
     * 和hssf一样　只不过加上了style
     *
     * @throws IOException
     * @throws Exception
     */
    @Test
    public void hssfStyle() throws IOException, Exception {
        //1:创建一个工作薄
        Workbook wb = new HSSFWorkbook();
        //2:创建一个工作表
        Sheet sheet = wb.createSheet();//默认名字
        //3:创建一个行对象
        Row row = sheet.createRow(5 - 1);//第五行　坐标从0开始
        //4:创建单元格　并且指定列
        Cell cell = row.createCell(6 - 1);//第六列　坐标依然是从０开始
        //5:给单元格设置内容
        cell.setCellValue("好好学习,天天向上!");

        //创建单元格样式 文泉驿等宽微米黑
        CellStyle style1 = wb.createCellStyle();
        cell.setCellStyle(setTitleStyle(wb,style1));

        //新创建一个单元格
        row = sheet.createRow(13-1);
        cell = row.createCell(5-1);
        cell.setCellValue("hello_world");
        CellStyle style2 = wb.createCellStyle();
        cell.setCellStyle(setContextStyle(wb,style2));

        FileOutputStream out = new FileOutputStream(path + "workbookA.xls");
        wb.write(out);
        out.flush();
        out.close();
        logger.info("end!");
    }

    public CellStyle setTitleStyle(Workbook wb, CellStyle style) {
        Font font = wb.createFont();
        font.setFontName("文泉驿等宽微米黑");
        font.setFontHeightInPoints((short) 22);
        style.setFont(font);
        return style;
    }

    public CellStyle setContextStyle(Workbook wb, CellStyle style) {
        Font font = wb.createFont();
        font.setFontName("Century Schoolbook L");
        style.setFont(font);
        return style;
    }
}
