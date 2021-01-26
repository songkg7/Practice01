package com.example.boardcontent.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OneOracleDao {
    String getHostName();
}
