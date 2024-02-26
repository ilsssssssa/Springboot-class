package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledConfig {

//  @Scheduled(fixedRate = 5000) // 5s
  public void fixedRateTask() throws InterruptedException {
    System.out.println("start: fixed");
    Thread.sleep(6000);
    System.out.println("end: fixed");
  }

//  @Scheduled(fixedDelay = 2000) // 2s
  public void fixedDelayTask() throws InterruptedException {
    System.out.println("start: fixedDelayTask " + System.currentTimeMillis());
    Thread.sleep(1000);
    System.out.println("end: fixedDelayTask");
  }

//  @Scheduled(cron = "*/5 * * * * ?") // every 5 sec, similar to fixedDelay
  @Async // 忙緊will help open new thread // 可以以非同步方式執行 // 調用時不會阻塞主線程，而是在新的線程中執行,執行順序是不確定的
  public void cronTask() throws InterruptedException {
    System.out.println("start cron");
    Thread.sleep(10000);
    System.out.println("end cron");
  }

//  @Scheduled(cron = "10 * * * * ?") // every 5 sec, similar to fixedDelay
  @Async
  public void cronTask10() throws InterruptedException {
    System.out.println("start cronTask10");
    Thread.sleep(10000);
    System.out.println("end cronTask10");
  }
}
