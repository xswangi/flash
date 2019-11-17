package com.springboot.demo.sort;

import java.util.Arrays;

public class ShellSort {//希尔排序
    public static  void main(String[] args){
        int[] array = new int[]{98,15,10,56,1,48,34,6,35};
        System.out.println("排序前："+ Arrays.toString(array));
        for (int gap = array.length / 2; gap > 0; gap /= 2) {//判断需要执行几次间隔排序
            int j;
            for (int i = gap; i < array.length; i++) {//以间隔数为第一个下标开始比较
                int temp = array[i];
                for (j = i; j>= gap && temp < array[j-gap] ; j -= gap) {
                    array[j] = array[j-gap];
                }
                array[j] = temp;
            }
        }
        System.out.println("排序后："+ Arrays.toString(array));
    }
}
