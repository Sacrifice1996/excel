package com.example.exceltest.excel;

import com.alibaba.excel.EasyExcel;
import com.example.exceltest.domain.RandomPeople;
import org.junit.Test;

/**
 * @author:汪健国
 * @createTime:2021/5/10 10:33
 */
public class ReadExcelAndSave {
    @Test
    public void read(){
        String path = "C:\\Users\\wjg\\Downloads\\1.xlsx";
        EasyExcel.read(path, RandomPeople.class,new PeopleReader()).sheet().doRead();
    }
}
