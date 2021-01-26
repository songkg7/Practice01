package com.example.boardcontent.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OneOracleServiceImpl implements OneOracleService {

    @Autowired
    private OneOracleDao oneOracleDao;

    @Override
    public String getHostName() {
        return null;
    }
}
