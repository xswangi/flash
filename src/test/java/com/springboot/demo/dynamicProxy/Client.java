package com.springboot.demo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args){
        Subject subject = new RealSubject();
        InvocationHandler handler = new DynamicSubject(subject);
        Subject object = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),subject.getClass().getInterfaces(),handler);
        object.rent();
        object.hello();
    }
}
