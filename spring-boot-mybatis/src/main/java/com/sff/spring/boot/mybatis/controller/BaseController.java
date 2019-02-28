package com.sff.spring.boot.mybatis.controller;

import com.sff.spring.boot.mybatis.dao.DeptMapper;
import com.sff.spring.boot.mybatis.dao.EmpMapper;
import com.sff.spring.boot.mybatis.domain.Dept;
import com.sff.spring.boot.mybatis.domain.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @GetMapping("/select")
    public List<Dept> select() {
        return deptMapper.selectAll();
    }

    @GetMapping("/find")
    public List<Emp> find() {
        return empMapper.selectAll();
    }

}
