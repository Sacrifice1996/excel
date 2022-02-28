package com.example.exceltest.mapper;

import com.example.exceltest.domain.RandomPeople;
import org.springframework.stereotype.Repository;

/**
 * @author:汪健国
 * @createTime:2021/5/10 10:59
 */
@Repository
public interface RandomPeopleMapper {
    void save(RandomPeople randomPeople);
}
