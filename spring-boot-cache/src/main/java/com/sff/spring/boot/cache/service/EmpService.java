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

    /**
     * @Cacheable ：将方法的结果进行缓存，以后在需要数据时，直接在缓存中获取，不会再调用方法
     * @Cacheable的几个属性：
     *     (1) cacheNames : 缓存的名字
     *
     *     (2) key : 该 cacheNames 缓存中的使用的key值，不指定时默认使用方法的参数，也可以
     *         使用 sepl 表达式来指定其值，比如：key="#id" 表示 queryEmp 方法的参数 id 的值，
     *         同时 "#id" 等价于 "#"a0、"#p0"、#root.args[0]
     *
     *     (3) keyGenerator : 指定key的生成器。key / keyGenerator 二选一使用，不要同时使用
     *     (4) cacheManager : 指定从哪个缓存管理器中取，比如在 RedisCache 还是 ConcurrentMapCache 中取值
     *     (5) condition : 指定缓存条件，满足某些条件后才缓存方法结果，也可以是 spel 表达式
     *         比如：condition = "#id > 0"
     *     (6) unless : 否定缓存，当 unless 指定的条件返回 true 是，方法结果就不会被缓存
     *         比如：unless = "#result == null" 意思是方法返回结果为空，不进行缓存
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"})
    public Emp queryEmp(Integer id) {
        System.out.println("查询员工ID: " + id);
        Emp emp = empMapper.queryEmpById(id);
        return emp;
    }





}
