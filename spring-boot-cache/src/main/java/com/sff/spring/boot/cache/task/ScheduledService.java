package com.sff.spring.boot.cache.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {


    /**
     * 格式：second（秒）,minute（分）, hour（小时）, day of month（日）, month（月） ,day of week（天）
     * 0 * * * * MON-FRI ：周一到周五每分钟执行一次
     * 0,1,2,3,4 * * * * SUN-MON : 每到 0,1,2,3,4 秒时执行
     * 0-4 * * * * SUN-MON : 每到 0,1,2,3,4 秒时执行
     * 0/4 * * * * SUN-MON : 0秒启动，每隔4秒执行一次
     */
    @Scheduled(cron = "0/4 * * * * SUN-MON")
    public void task() {
        System.out.println("每隔4秒...");
    }

    @Scheduled(cron = "0/2 * * * * SUN-MON")
    public void task01() {
        System.out.println("每隔2秒...");
    }

    @Scheduled(cron = "0/3 * * * * SUN-MON")
    public void task03() {
        System.out.println("每隔3秒...");
    }

}
