package com.springboot.demo.mst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectSort {

    public static void main(String[] args){
        int n = 20;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                count++;
            }
        }
        if(count > 0){
            System.out.println(n+"不为质数");
            return;
        }
        System.out.println(n+"为质数");
    }

}
