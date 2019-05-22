package com.sff.spring.boot.cache.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    @Async
    public void async(){
        System.out.println("----方法同步逻辑----");
        System.out.println("异步逻辑");
        System.out.println("----方法同步逻辑----");
    }
}
