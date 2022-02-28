package com.example.exceltest.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.exceltest.domain.NewExcel;
import com.example.exceltest.domain.OldExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelReader extends AnalysisEventListener<OldExcel> {

    private List<NewExcel> newExcels = new ArrayList<>();

    public List<NewExcel> list() {
        return this.newExcels;
    }

    @Override
    public void invoke(OldExcel data, AnalysisContext context) {
        log.info("查询一条数据", data.toString());
        NewExcel newExcel = new NewExcel(data.getColumn1(), data.getColumn2(), data.getColumn1() + data.getColumn2());
        System.out.println(newExcel);
        newExcels.add(newExcel);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("数据全部查询完成");
    }
}
