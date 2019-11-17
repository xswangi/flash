package com.springboot.demo.sort;

import java.util.Arrays;

public class SelectionSort {//选择排序
    public static  void main(String[] args){
        int[] array = new int[]{98,15,10,56,1,48,34,6,35};
        int minIndex,temp;
        System.out.println("排序前："+ Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[minIndex] > array[j]){//寻找最小数
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        System.out.println("排序后："+ Arrays.toString(array));
    }
}
