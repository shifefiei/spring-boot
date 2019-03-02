package com.sff.spring.boot.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emp implements Serializable {

    private Long id;
    private String name;
    private Integer sex;
    private String email;
    private Long deptId;

}
