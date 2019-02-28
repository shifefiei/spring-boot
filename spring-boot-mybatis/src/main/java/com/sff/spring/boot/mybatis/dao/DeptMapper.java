package com.sff.spring.boot.mybatis.dao;

import com.sff.spring.boot.mybatis.domain.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> selectAll();

}
