package com.sff.spring.boot.cache.dao;


import com.sff.spring.boot.cache.domain.Emp;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {

    @Select("select * from emp where id = #{id}")
    Emp queryEmpById(Integer id);
}
