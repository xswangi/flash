package com.springboot.demo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {
    private Object realSubject;
    public DynamicSubject(Object subject){
        this.realSubject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        System.out.println("before-----");
        method.invoke(realSubject,args);
        System.out.println("after-------");
        return null;
    }
}
