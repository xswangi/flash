package com.springboot.demo;

public class Stack {
    private Object[] array;
    private int maxSize;
    private int top;
    public Stack(){
        this.maxSize = 16;
        array = new Object[maxSize];
        top = -1;
    }
    public Stack(int size){
        this.maxSize = size;
        array = new Object[maxSize];
        top = -1;
    }
    //进栈
    public void pushStack(Object value){
        if(top < maxSize - 1){
            array[++top] = value;
        }
    }

    //出栈
    public Object popStack(){
        return array[top--];
    }
    //访问栈顶元素
    public Object peek(){
        return array[top];
    }
    //判断是否为空栈
    public boolean isEmpty(){
        return top == -1;
    }
    //判断栈是否已满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //main方法
    public static void main(String[] args){
        Stack myStack = new Stack(4);
        myStack.pushStack(1);
        myStack.pushStack(2);
        myStack.pushStack(3);
        myStack.pushStack(4);
        System.out.println("栈顶元素："+myStack.peek());
        System.out.print("元素出栈：");
        while(!myStack.isEmpty()){
            System.out.print(myStack.popStack()+" ");
        }
    }

}
