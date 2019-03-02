package com.sff.spring.boot.cache.controller;

import com.sff.spring.boot.cache.domain.Emp;
import com.sff.spring.boot.cache.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private EmpService empService;

    @GetMapping("/query/{id}")
    public Emp query(@PathVariable Integer id) {
        return empService.queryEmp(id);
    }

}
