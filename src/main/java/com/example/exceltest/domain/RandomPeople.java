package com.example.exceltest.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:汪健国
 * @createTime:2021/5/10 10:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RandomPeople {

    @ExcelProperty(value = "ID",index = 0)
    private String id;

    @ExcelProperty(value = "经度",index = 1)
    private Double lng;

    @ExcelProperty(value = "纬度",index = 2)
    private Double lat;

    @ExcelProperty(value = "参考地址",index = 3)
    private String address;

    @ExcelProperty(value = "街镇",index = 4)
    private String street;

    @ExcelProperty(value = "路名",index = 5)
    private String road;

    @ExcelProperty(value = "城地X",index = 6)
    private Double city_x;

    @ExcelProperty(value = "城地Y",index = 7)
    private Double city_y;

    @ExcelProperty(value = "随机生成数据",index = 8)
    private Integer random;

}
