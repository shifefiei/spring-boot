package com.sff.spring.boot.cache.service;

import com.sff.spring.boot.cache.dao.DeptMapper;
import com.sff.spring.boot.cache.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Cacheable(cacheNames = {"dept"})
    public Dept queryDept(Integer id) {
        System.out.println("--------------->>>查询部门id : " + id);
        Dept dept = deptMapper.find(id);
        return dept;
    }
}
