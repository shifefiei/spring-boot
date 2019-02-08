package com.sff.spring.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate; //注入 JdbcTemplate 模板

    @ResponseBody
    @RequestMapping("/jdbc")
    public String query() {
        List<Map<String, Object>> deptList = jdbcTemplate.queryForList("SELECT id,dept_name FROM dept");
        return deptList.toString();
    }
}
