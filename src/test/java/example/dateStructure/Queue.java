package example.dateStructure;

public class Queue {//对列--数组实现
    private static Object[] array;
    private static int maxSize;
    private static int front;//队头
    private static int rear;//队尾
    private static int nItems;//实际元素个数

    //队列初始化
    public Queue(int size){
        maxSize = size;
        array = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //入队
    public void push(Object value){
        if(isFull()){
            throw new IllegalArgumentException("队列已满");
        }
        if(rear == maxSize - 1){
            rear = -1;
        }
        array[++rear] = value;
        nItems++;
    }
    //出队
    public Object pop(){
        Object object = null;
        if(isEmpty()){
            System.out.println("对列为空");
        }
        object = array[front];
        array[front] = null;
        if(front == maxSize - 1){
            front = 0;
        }
        else {
            front++;
        }
        nItems--;
        return object;
    }

    //查看队列头部元素
    public void peek(){
        if(isEmpty()){
            System.out.println("队列为空");
        }
        System.out.println(array[front]);
    }

    //队列是否已满
    public boolean isFull(){
        return nItems == maxSize;
    }
    //对列是否为空
    public boolean isEmpty(){
        return nItems == 0;
    }

    public static void main(String[] args){
        Queue queue = new Queue(5);
        queue.push(5);
        queue.push(4);
        queue.push(7);
        queue.push(1);
        queue.push(9);
        queue.peek();
        queue.pop();
        queue.peek();
    }
}

