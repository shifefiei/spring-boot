package com.sff.spring.boot.cache.dao;

import com.sff.spring.boot.cache.domain.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> selectAll();

    @Select("select * from dept where id = #{id}")
    Dept find(Integer id);

}
