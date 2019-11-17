package com.springboot.demo;

public class RBNode1<T extends Comparable<T>> {//红黑树--节点类
    private static final Boolean RED = false;
    private static final Boolean BLACK = true;
    boolean color;//颜色
    T key;//关键值
    RBNode1<T> left;//左子节点
    RBNode1<T> right;//右子节点
    RBNode1<T> parent;//父节点
    public RBNode1(boolean color,T key,RBNode1<T> parent,RBNode1<T> left,RBNode1<T> right){
        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    //获得节点的关键值
    public T getKey(){
        return key;
    }
    //打印节点的关键值和颜色信息
    public String toString(){
        return ""+key+(this.color == RED ? "R":"B");
    }
}
