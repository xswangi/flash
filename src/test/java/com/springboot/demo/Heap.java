package com.springboot.demo;
public class Heap {//堆
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;
    public Heap(){

    }
    public Heap(int size){
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }
    //内部类Node
    class Node{
        private int data;
        public Node(int data){
            this.data = data;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
    }
    //判断堆是否为空
    public boolean isEmpty(){
        return currentSize==0;
    }
    //判断堆是否已满
    public boolean isFull(){
        return currentSize==maxSize;
    }
    //往堆中插数据
    public boolean insert(int data){
        if (isFull()){
            return false;
        }
        Node newNode = new Node(data);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }
    //插入时向上调整
    public void trickleUp(int index){
        int parent = (index - 1)/2;//父结点的索引
        Node bottom = heapArray[index];//将新加的尾结点存在bottom中
        while(index > 0 && bottom.data > heapArray[parent].data){
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (index - 1)/2;
        }
        heapArray[index] = bottom;
    }
    //删除堆中根结点
    public Node remove(){
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickLeDown(0);
        return root;
    }
    //删除时向下调整
    public void trickLeDown(int index){
        Node top = heapArray[index];
        int largeChildIndex;
        while (index < currentSize/2){//判断当前结点是否时父结点（currentSize/2）是父结点的个数
            int leftChildIndex = (index * 2) + 1;
            int rightChildIndex = (index * 2) + 2;
            //find large Child
            if(rightChildIndex < currentSize && heapArray[leftChildIndex].data < heapArray[rightChildIndex].data){
                largeChildIndex = rightChildIndex;
            }
            else {
                largeChildIndex = leftChildIndex;
            }
            if(top.data >= heapArray[largeChildIndex].data){
                break;
            }
            else {
                heapArray[index] = heapArray[largeChildIndex];
                index = largeChildIndex;
            }
        }
        heapArray[index] = top;
    }
    //根据索引改变堆中某个数据
    public boolean change(int index,int newValue){
        if(index < 0 || index >= currentSize){//想改变的值的索引大于当前存在的最大索引
            return false;
        }
        int oldVale = heapArray[index].data;
        heapArray[index].setData(newValue);
        if(oldVale < newValue){
            trickleUp(index);
        }
        else if(oldVale > newValue){
            trickLeDown(index);
        }
        return true;
    }
    //输出堆中数据
    public void displayHeap() {
        System.out.println("heapArray(array format): ");
        for(int i = 0; i < currentSize; i++) {
            if(heapArray[i] != null) {
                System.out.print(heapArray[i].getData() + " ");
            }
            else {
                System.out.print("--");
            }
        }
    }
    //main方法
    public static void main(String[] args){
        Heap heap = new Heap(5);
        heap.insert(1);
        heap.insert(5);
        heap.insert(8);
        heap.insert(10);
        heap.insert(6);
        heap.displayHeap();
        heap.change(4,11);
        heap.displayHeap();
        System.out.println();
        System.out.println("删除根结点："+heap.remove().data);
        heap.displayHeap();
    }
}
