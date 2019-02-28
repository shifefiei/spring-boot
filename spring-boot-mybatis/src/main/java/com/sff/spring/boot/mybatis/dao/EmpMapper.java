package com.sff.spring.boot.mybatis.dao;

import com.sff.spring.boot.mybatis.domain.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> selectAll();
}
