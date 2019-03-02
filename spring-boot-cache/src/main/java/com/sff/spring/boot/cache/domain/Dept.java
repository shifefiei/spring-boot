package com.sff.spring.boot.cache.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dept implements Serializable {

    private long id;
    private String deptName;

}
