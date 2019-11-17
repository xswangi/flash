package com.springboot.demo.sort;

import java.util.Arrays;

public class BubbleSort {//冒泡排序
    public static  void main(String[] args){
        int[] array = new int[]{98,15,10,56,1,48,34,6,35};
        System.out.println("排序前："+ Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {//需要循环n-1次
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("排序后："+ Arrays.toString(array));
    }


}
