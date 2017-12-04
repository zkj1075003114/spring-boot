package com.dream.springbootmybatis.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling // 启用定时任务
public class SchedulingConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "0/20 30 1 * * ?") // 每20秒执行一次
    public void scheduler() {
        logger.info(">>>>>>>>>>>>> 20 scheduled ... ");
    }

}