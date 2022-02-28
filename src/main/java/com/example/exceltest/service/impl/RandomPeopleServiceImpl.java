package com.example.exceltest.service.impl;

import com.example.exceltest.domain.RandomPeople;
import com.example.exceltest.mapper.RandomPeopleMapper;
import com.example.exceltest.service.RandomPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:汪健国
 * @createTime:2021/5/10 11:01
 */
@Service
public class RandomPeopleServiceImpl implements RandomPeopleService {

    @Autowired
    private RandomPeopleMapper randomPeopleMapper;

    @Override
    public void save(RandomPeople randomPeople) {
        randomPeopleMapper.save(randomPeople);
    }
}
