package com.springboot.demo.sort;


import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Erfen {//二分法

    public int recursionBinarySearch(int[] array,int value,int low,int height){
        if(value < array[low] || value > array[height] || low > height){
            return -1;
        }
        int middle = (low + height) / 2;
        if(value > array[middle]){
            return recursionBinarySearch(array,value,middle+1,height);
        }
        else if (value < array[middle]){
            return recursionBinarySearch(array,value,low,middle - 1);
        }
        else {
            return middle;
        }
    }


    public static void main(String[] args){
        /*int[] array = new int[]{1,3,5,7,9,11};
        Erfen ef = new Erfen();
        int position = ef.recursionBinarySearch(array,11,0,array.length-1);
        if(position == -1){
            System.out.println("未查到该数");
        }
        else {
            System.out.println("该数的数组下标为："+position);
        }*/
        Object[] array = new Object[]{"a","c","d","c","c","a"};
        HashMap<Object,Integer> seMap = new HashMap<>();
        for(int i = 0;i<array.length;i++){
            Integer count = 0;
            count = seMap.get(array[i]);
            if(count == null || count == 0){

                seMap.put(array[i],1);
            }
            else {
                count++;
                seMap.put(array[i],count);
            }
        }
        Set keys = seMap.keySet();
        for (Object ob : keys){
            String key = ob.toString();
            System.out.println(ob.toString()+":"+seMap.get(key));
        }
    }







}
