package com.example.exceltest.excel;


import com.alibaba.excel.EasyExcel;
import com.example.exceltest.domain.NewExcel;
import com.example.exceltest.domain.OldExcel;
import org.junit.Test;

import java.util.List;

public class ExcelTest {
    @Test
    public void readExcel(){
        String oldPath = "C:\\Users\\wjg\\Desktop\\old.xlsx";
        List<NewExcel> newExcels = new ExcelReader().list();
        System.out.println("---------------------------------------------");
        System.out.println(newExcels);
        EasyExcel.read(oldPath, OldExcel.class,new ExcelReader()).sheet().doRead();
        String newPath = "C:\\Users\\wjg\\Desktop\\new.xlsx";
        EasyExcel.write(newPath,NewExcel.class).sheet("结果表").doWrite(newExcels);
    }

    @Test
    public void writeExcel(){
        String newPath = "C:\\Users\\wjg\\Desktop\\new.xlsx";
        List<NewExcel> newExcels = new ExcelReader().list();
        System.out.println("---------------------------------------------");
        System.out.println(newExcels);
        EasyExcel.write(newPath,NewExcel.class).sheet("结果表").doWrite(newExcels);
    }
}
