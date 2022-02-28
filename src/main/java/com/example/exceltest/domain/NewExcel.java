package com.example.exceltest.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewExcel {
    @ExcelProperty(value = "值1", index = 0)
    private Integer column1;
    @ExcelProperty(value = "值2", index = 1)
    private Integer column2;
    @ExcelProperty(value = "结果", index = 2)
    private Integer column3;
}
