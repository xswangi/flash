package com.springboot.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMS {
    private static AtomicInteger count = new AtomicInteger(0);
    static CountDownLatch countDownLatch = new CountDownLatch(100);
    public static void main(String[] args){

        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 100; j++) {
                        count.getAndIncrement();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        }
        catch (InterruptedException in){
            in.printStackTrace();
        }
        System.out.println("count为："+count);
        service.shutdown();
    }
}
