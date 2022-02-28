package com.example.exceltest.excel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class poi2 {

    XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\wjg\\Desktop\\222.xlsx"));
    String writePath = "C:\\Users\\wjg\\Desktop\\999.xlsx";

    public poi2() throws IOException {
    }


    @Test
    public void test() throws Exception {
        XSSFSheet oldSheet = wb.getSheetAt(0);
        XSSFCellStyle cellStyle = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        int allRows = oldSheet.getLastRowNum() + 1;
        int validRows = allRows - 2;
        int validSheets = (int) Math.ceil(validRows / 10000.0);
        for (int x = 1; x <= validSheets; x++) {
            createAndInsertSheet(oldSheet, "newSheet" + x, (x - 1) * 10000 + 2, x * 10000 + 2, cellStyle, font);
        }
        write();
    }

    //设置每一个sheet的前两行
    public void setRow0AndRow1(XSSFSheet oldSheet, XSSFSheet newSheet, XSSFCellStyle cellStyle) {
//        newSheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
        //对每一个sheet的第0行进行初始化
        XSSFRow newSheetRow0 = newSheet.createRow(0);
        cellStyle.setBorderRight(BorderStyle.THIN);
        XSSFCell newSheetRow0Cell0 = newSheetRow0.createCell(0);
        newSheetRow0Cell0.setCellStyle(cellStyle);
        newSheetRow0Cell0.setCellValue(oldSheet.getRow(0).getCell(0).getStringCellValue());
//        newSheet.addMergedRegion(new CellRangeAddress(0,0,0,2));

        //对每一个sheet的第1行进行初始化
        XSSFRow sheet1Row1 = newSheet.createRow(1);
        XSSFCell sheet1Row1Cell0 = sheet1Row1.createCell(0);
        XSSFCell sheet1Row1Cell1 = sheet1Row1.createCell(1);
        XSSFCell sheet1Row1Cell2 = sheet1Row1.createCell(2);
        sheet1Row1Cell0.setCellValue(oldSheet.getRow(1).getCell(0).getStringCellValue());
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        sheet1Row1Cell0.setCellStyle(cellStyle);
        sheet1Row1Cell1.setCellValue(oldSheet.getRow(1).getCell(1).getStringCellValue());
        sheet1Row1Cell1.setCellStyle(cellStyle);
        sheet1Row1Cell2.setCellValue(oldSheet.getRow(1).getCell(2).getStringCellValue());
        sheet1Row1Cell2.setCellStyle(cellStyle);

    }

    //创建并插入和计算数据
    public void createAndInsertSheet(XSSFSheet oldSheet, String sheetName, int beginRow, int endRow, XSSFCellStyle cellStyle, XSSFFont font) {
        if (endRow >= oldSheet.getLastRowNum() + 1) {
            endRow = oldSheet.getLastRowNum() + 1;
        }
        XSSFSheet sheet = wb.createSheet(sheetName);
        for (int i = beginRow, k = 2; i < endRow; i++, k++) {

            setRow0AndRow1(oldSheet, sheet, cellStyle);
            XSSFRow oldRow = oldSheet.getRow(i);
            XSSFRow newRow = sheet.createRow(k);
            for (int j = 0; j < oldRow.getLastCellNum() + 1; j++) {
                cellStyle.setBorderTop(BorderStyle.THIN);
                cellStyle.setBorderBottom(BorderStyle.THIN);
                cellStyle.setBorderLeft(BorderStyle.THIN);
                cellStyle.setBorderRight(BorderStyle.THIN);
                if (j == 2) {
                    Double value = oldRow.getCell(j - 2).getNumericCellValue() +
                            oldRow.getCell(j - 1).getNumericCellValue();
                    XSSFCell cell = newRow.createCell(j);
                    cell.setCellValue(value);
                    if (value > 100) {
                        XSSFFont font1 = wb.createFont();
                        XSSFCellStyle cellStyle1 = wb.createCellStyle();
                        cellStyle1.setBorderTop(BorderStyle.THIN);
                        cellStyle1.setBorderBottom(BorderStyle.THIN);
                        cellStyle1.setBorderLeft(BorderStyle.THIN);
                        cellStyle1.setBorderRight(BorderStyle.THIN);
                        font1.setColor(HSSFColor.RED.index);
                        cellStyle1.setFont(font1);
                        cell.setCellStyle(cellStyle1);
                        break;
                    }
                    cell.setCellStyle(cellStyle);
                    break;
                }
                XSSFCell cell = newRow.createCell(j);
                cell.setCellValue(oldRow.getCell(j).getNumericCellValue());
                cell.setCellStyle(cellStyle);
            }
        }
    }

    //写出文件
    public void write() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(writePath);
        wb.write(fileOutputStream);
        fileOutputStream.close();
        wb.close();
    }
}

