package com.example.exceltest.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OldExcel {
    @ExcelProperty("值1")
    private Integer column1;
    @ExcelProperty("值2")
    private Integer column2;
    @ExcelProperty("结果")
    @ExcelIgnore
    private Integer column3;
}
