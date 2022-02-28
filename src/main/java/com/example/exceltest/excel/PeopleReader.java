package com.example.exceltest.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.exceltest.domain.RandomPeople;
import com.example.exceltest.service.RandomPeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:汪健国
 * @createTime:2021/5/10 10:52
 */
@Slf4j
public class PeopleReader extends AnalysisEventListener<RandomPeople> {


    @Override
    public void invoke(RandomPeople randomPeople, AnalysisContext context) {
        log.info("查询一条数据", randomPeople.toString());
        System.out.println(randomPeople);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("数据全部查询完成");
    }
}
