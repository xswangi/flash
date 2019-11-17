package com.springboot.demo.sort;

import java.util.Arrays;

public class QuickSort {//快速排序
    public static void main(String[] args) {
        int[] array = {9,9,8,7,6,5,4,3,2,1};
        System.out.println("排序前："+ Arrays.toString(array));
        sort(array);
        System.out.println("排序后："+ Arrays.toString(array));
    }
    public static void sort(int[] array){
        recQuickSort(array,0,array.length-1);
    }
    public static void recQuickSort(int[] array,int left,int right){
        if(right <= left){
            return;
        }
        else{
            int partition = partitionIt(array,left,right);
            recQuickSort(array,left,partition-1);
            recQuickSort(array,partition+1,right);
        }
    }
    public static int partitionIt(int[] array ,int left,int right){
        int i = left;//左游标,向右扫描
        int j = right+1;//右游标，向左扫描
        int pivot = array[left];//选取的基准元素
        while (true){
            while (i < right && array[++i] < pivot){}
            while (j > left && array[--j] > pivot){}
            if(i >= j){//左右游标相遇时停止
                break;
            }
            else{
                swap(array,i,j);//左右游标未相遇时停止，交换各自所指元素，循环继续
            }
        }
        swap(array,left,j);
        return j;
    }
    //交换数据
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
