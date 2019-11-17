package com.springboot.demo;

public class Recursion {
    public static void main(String[] args){
        int num = 0;
        int n = 0;
        int count = recursion(num,n);
        System.out.println("递归实现1到100的和："+count);
        int count1 = recursionMutil(4);
        System.out.println("递归实现n的阶乘："+count1);
    }
    //递归实现1到100的和
    public static Integer recursion(int count,int n){
        if(n < 100){
            n = n + 1;
            count = n + recursion(count,n);
        }
        return count;
    }

    //递归实现n的阶乘
    public static Integer recursionMutil(int n){
        if(n == 0){
            return 1;
        }
        return n * recursionMutil(--n);
    }
}
