package com.springboot.demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiskMemory {
    private int totalSize;
    public int getSize(){
        return (new Random().nextInt(4)+1)*100;
    }
    public synchronized void setSize(int size){
        totalSize += size;
    }
    public int getTotalSize(){
        return totalSize;
    }
    public static void main(String[] args){
        CountDownLatch count = new CountDownLatch(4);
        DiskMemory diskMemory = new DiskMemory();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        int time = new Random().nextInt(5);
                        Thread.sleep(time*1000);
                    }
                    catch (InterruptedException in){
                        in.printStackTrace();
                    }
                    int size = diskMemory.getSize();
                    System.out.println(Thread.currentThread()+"获取磁盘大小为："+size);
                    diskMemory.setSize(size);
                    count.countDown();
                }
            });
        }
        try{
            count.await();
        }
        catch (InterruptedException in){
            in.printStackTrace();
        }
        System.out.println("主线程获取总共磁盘大小为："+diskMemory.getTotalSize());
        service.shutdown();
    }
}
