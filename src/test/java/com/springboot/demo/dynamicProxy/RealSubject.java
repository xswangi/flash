package com.springboot.demo.dynamicProxy;

public class RealSubject implements Subject {

    @Override
    public void rent(){
        System.out.println("买房卖房上五八同城");
    }

    @Override
    public void hello(){
        System.out.println("welcome to China ！");
    }
}
