package com.springboot.demo.sort;

import java.util.Arrays;

public class InsertionSort {//插入排序
    public static  void main(String[] args){
        int[] array = new int[]{98,15,10,56,1,48,34,6,35};
        int preIndex,current;
        System.out.println("排序前："+ Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            preIndex = i-1;
            while (preIndex >= 0 && array[preIndex] > current){
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
        System.out.println("排序后："+ Arrays.toString(array));
    }
}
