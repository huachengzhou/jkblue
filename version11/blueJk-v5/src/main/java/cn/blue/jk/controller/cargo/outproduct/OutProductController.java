package cn.blue.jk.controller.cargo.outproduct;

import cn.blue.common.view.VIEW;
import cn.blue.jk.exception.ControllerException;
import cn.blue.jk.service.OutProductService;
import cn.blue.jk.util.DownloadUtil;
import cn.blue.jk.util.poi.ExcelUtil;
import cn.blue.jk.vo.OutProductVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

import static cn.blue.jk.util.poi.ExcelUtil.titleStyle;

@Controller
public class OutProductController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OutProductService outProductService;

    /**
     * 转向编辑页面
     *
     * @return
     * @throws ControllerException
     */
    @RequestMapping(value = "/cargo/outproduct/toedit.action")
    public String toedit() throws ControllerException {
        logger.info("/cargo/outproduct/toedit.action");
        return VIEW.Pages.getVar() + "cargo/outproduct/jOutProduct" + VIEW.JSP.getVar();
    }

    /**
     * 不用模板　xlsx和xls 都支持
     * @param inputDate
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/cargo/outproduct/print.action")
    public ResponseEntity<byte[]> print(String inputDate, HttpServletRequest request, HttpServletResponse response) {
        logger.info("/cargo/outproduct/print.action");
        logger.info(inputDate);
        List<OutProductVO> voList = outProductService.outProducts(inputDate);
//        ByteArrayOutputStream byteArray = poiHSSF(voList, new HSSFWorkbook());
        ByteArrayOutputStream byteArray = poi(voList, new XSSFWorkbook());//可以任意选择,就是没有样式了
//        String fileName = inputDate + ".xls";
        String fileName = inputDate + ".xlsx";
        ResponseEntity<byte[]> responseEntity = new DownloadUtil().createResponse(fileName, byteArray.toByteArray());
        return responseEntity;
    }

    /**
     * 使用模板xlsx格式
     * @param inputDate
     * @param request
     * @param response
     * @return
     */
    public ResponseEntity<byte[]> printL(String inputDate, HttpServletRequest request, HttpServletResponse response) {
        String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
        InputStream is = null;
        ResponseEntity<byte[]> responseEntity = null;
        try {
            is = new FileInputStream(new File(path + "tOUTPRODUCT.xlsx"));
            List<OutProductVO> dataList = outProductService.outProducts(inputDate);
            ByteArrayOutputStream byteArray = poiXSSF(is, dataList, inputDate);
            String fileName = inputDate + ".xlsx";
            responseEntity = new DownloadUtil().createResponse(fileName, byteArray.toByteArray());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return responseEntity;
    }


    public ByteArrayOutputStream poiXSSF(InputStream is, List<OutProductVO> dataList, String var) throws IOException {
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
        nCell.setCellValue(var + UUID.randomUUID().toString());
        CellStyle headStyle = wb.createCellStyle();
        headStyle = ExcelUtil.bigTitleStyle(wb);
        nCell.setCellStyle(headStyle);

        //标题列
        CellStyle titleStyle = ExcelUtil.titleStyle(wb);
        String[] titles = {"客户", "订单号", "货号", "数量", "工厂", "工厂交期", "船期", "贸易条款"};
        nRow = sheet.createRow(rowNo++);
        for (int i = 0; i < titles.length; i++) {
            nCell = nRow.createCell(i + 1);
            nCell.setCellValue(titles[i]);
            nCell.setCellStyle(titleStyle);
        }
        //处理内容
        for (int j = 0; j < dataList.size(); j++) {
            colNo = 1;                //初始化
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
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024 * 2);
        try {
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    public ByteArrayOutputStream poi(List<OutProductVO> voList, Workbook wb) {
        Sheet sheet = wb.createSheet();
        Row row = null;//第二行
        Cell cell = null;
        String[] titles = {"客户", "订单号", "货号", "数量", "工厂", "工厂交期", "船期", "贸易条款"};
        int rowNo = 0; //行号
        int celNo = 1;//列号

        sheet.setColumnWidth(0, 19 * 22);//列的宽度
        for (int i = 0; i < titles.length; i++) {
            sheet.setColumnWidth(i + 1, 19 * 256);//列的宽度
        }

        //大标题合并
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, titles.length + 1));
        row = sheet.createRow(rowNo++);
        cell = row.createCell(1);
        cell.setCellValue("客户订单报表");//合并单元格的内容写在合并前第一个单元格
        CellStyle titleStyle = ExcelUtil.bigTitleStyle(wb);
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
        contentStyle = ExcelUtil.textStyle(wb, contentStyle, contentFont);
        //处理数据行
        for (int i = 0; i < voList.size(); i++) {
            OutProductVO vo = voList.get(i);
            row = sheet.createRow(rowNo++);
            if (celNo != 1) celNo = 1;//初始化　一行写完以后才调用
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
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024 * 2);
        try {
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }
}
