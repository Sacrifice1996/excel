package com.example.exceltest.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Iterator;

/**
 * @author:汪健国
 * @createTime:2021/5/10 9:36
 */
public class MysqlTest {
    @Test
    public void readPeople() throws Exception {
        String path = "C:\\Users\\wjg\\Downloads\\1.xlsx";
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(path));
        XSSFSheet sheet = book.getSheet("随机生成数据模板");
        XSSFRow row = sheet.getRow(0);
        Iterator<Cell> ite = row.cellIterator();
        int num = -1;
        while (ite.hasNext()) {
            num++;
            if (num > 10) {
                break;
            }
            Cell cell = ite.next();
            String cname = cell.getStringCellValue();
            System.out.print(cname);
            System.out.print(",");
        }

        System.out.println("-----------------------------------");

        //获取除第一行外的接下来的行
        Iterator<Row> it = sheet.rowIterator();
        XSSFRow row1 = sheet.getRow(0);
        while (it.hasNext()) {//遍历所有行
            row = (XSSFRow) it.next();
            if (row == row1) {
                continue;
            }
            XSSFCell cell0 = row.getCell(0);
            XSSFCell cell1 = row.getCell(1);
            XSSFCell cell2 = row.getCell(2);
            XSSFCell cell3 = row.getCell(3);
            XSSFCell cell4 = row.getCell(4);
            XSSFCell cell5 = row.getCell(5);
            XSSFCell cell6 = row.getCell(6);
            XSSFCell cell7 = row.getCell(7);
            XSSFCell cell8 = row.getCell(8);
            String rawValue0 = cell0.getRawValue();
            System.out.print(rawValue0);
            String rawValue1 = cell1.getRawValue();
            System.out.print(rawValue1);
            String rawValue2 = cell2.getRawValue();
            System.out.print(rawValue2);
            String rawValue3 = cell3.getRawValue();
            System.out.print(rawValue3);

            System.out.println("-----------------------------------");
        }
    }

    @Test
    public void readHouse() {

    }

    @Test
    public void readCompany() {

    }
}
