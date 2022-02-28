package com.example.exceltest.excel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class poi {
    @Test
    public void test() throws IOException {
        //获取文档操作对象
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\wjg\\Desktop\\666.xlsx"));
        //获取工作表对象,sheet的索引从0开始
        XSSFSheet sheet1 = wb.getSheetAt(0);
        //根据该sheet的数据所在的行,逐行获取每列对象中的数据(row为行,cell为单元格),单元格的索引也是从0开始
        for (int i = 2; i < sheet1.getLastRowNum() + 1; i++) {
            //获取单元格对象
            XSSFRow row = sheet1.getRow(i);
            //获取单元格对象的值,索引也是从0开始
            Double d1 = Double.parseDouble(row.getCell(0).toString());
            Double d2 = Double.parseDouble(row.getCell(1).toString());
            XSSFCell cell = row.createCell(2);
            Double d3 = d1 + d2;
//            row.createCell(2).setCellValue(row.getCell(0).getNumericCellValue()+
//                    row.getCell(1).getNumericCellValue());
            cell.setCellValue(d3);
            //设置单元格的样式
            XSSFCellStyle style = wb.createCellStyle();
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            XSSFFont font = wb.createFont();
            if (d3 > 100) {
                font.setColor(HSSFColor.RED.index);
            }
            //顺序不可颠倒
            style.setFont(font);
            cell.setCellStyle(style);
        }
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\wjg\\Desktop\\777.xlsx");
        wb.write(fileOutputStream);
        wb.close();
    }
}
