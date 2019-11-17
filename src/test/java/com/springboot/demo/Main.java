package com.springboot.demo;

import org.springframework.util.LinkedMultiValueMap;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger count = new AtomicInteger(0);
    static CountDownLatch cdl = new CountDownLatch(1000);
    public static void main(String[] args) throws Exception{

        /*MyThread myThread = new MyThread();
        for (int i = 0; i < 1000; i++) {
            new Thread(myThread).start();
        }
        cdl.await();
        System.out.println(count);*/
        Class<?> clazz = Class.forName("com.springboot.demo.Heap");
        Object object = clazz.newInstance();
        System.out.println(object);
    }
     static class MyThread implements Runnable{
        Set map = new HashSet();
        public void count(){
            for (int i = 0; i < 1000 ; i++) {
                count.getAndIncrement();
            }
        }
        @Override
        public void run(){
            count();
            cdl.countDown();
        }
    }


}
