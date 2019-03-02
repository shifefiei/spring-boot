package com.sff.spring.boot.cache.service;

import com.sff.spring.boot.cache.dao.EmpMapper;
import com.sff.spring.boot.cache.domain.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Cacheable(cacheNames = {"emp"})
    public Emp queryEmp(Integer id) {
        System.out.println("查询员工ID: " + id);
        Emp emp = empMapper.queryEmpById(id);
        return emp;
    }

}
