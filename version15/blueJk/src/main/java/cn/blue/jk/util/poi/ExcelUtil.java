package cn.blue.jk.util.poi;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil {
    //大标题样式
    public static CellStyle bigTitleStyle(Workbook wb) {
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        curFont.setFontName("宋体");
        curFont.setFontHeightInPoints((short) 16);
        curFont.setBoldweight(Font.BOLDWEIGHT_BOLD);                    //字体加粗

        curStyle.setFont(curFont);                                        //绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_CENTER);                    //横向居中
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);        //纵向居中

        return curStyle;
    }

    //小标题样式
    public static CellStyle titleStyle(Workbook wb) {
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        curFont.setFontName("黑体");
        curFont.setFontHeightInPoints((short) 12);

        curStyle.setFont(curFont);                                        //绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_CENTER);                    //横向居中
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);        //纵向居中


        curStyle.setBorderTop(CellStyle.BORDER_THIN);                    //设置四周边线，细线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);
        curStyle.setBorderLeft(CellStyle.BORDER_THIN);
        curStyle.setBorderRight(CellStyle.BORDER_THIN);

        return curStyle;
    }

    //文字样式
    public static CellStyle textStyle(Workbook wb, CellStyle curStyle, Font curFont) {

        curFont.setFontName("Times New Roman");
        curFont.setFontHeightInPoints((short) 10);

        curStyle.setFont(curFont);                                        //绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_LEFT);                    //横向居左
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);        //纵向居中


        curStyle.setBorderTop(CellStyle.BORDER_THIN);                    //设置四周边线，细线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);
        curStyle.setBorderLeft(CellStyle.BORDER_THIN);
        curStyle.setBorderRight(CellStyle.BORDER_THIN);

        return curStyle;
    }
}
