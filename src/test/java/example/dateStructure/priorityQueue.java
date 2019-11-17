package example.dateStructure;

public class priorityQueue {//优先级队列--数组实现
    private static Object[] array;
    private static int maxSize;
    private static int nItems;//实际元素个数

    public priorityQueue(int size){
        maxSize = size;
        array = new Object[maxSize];
        nItems = 0;
    }
    public void push(Object value){
        if(isFull()){
            System.out.println("队列已满");
        }
        if(isEmpty()){
            array[nItems] = value;
        }
        else {//从小到大排序
            int head = nItems - 1;
            while (head >= 0 && (Integer)value > (Integer) array[head]){
                array[head+1] = array[head];
                head--;
            }
            array[head+1] = value;
        }
        nItems++;
    }
    public Object pop(){
        Object object = null;
        if (isEmpty()){
            System.out.println("队列为空");
        }
        else {
            object = array[nItems-1];
            array[nItems-1] = -1;
            nItems--;

        }
        return object;
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
        priorityQueue queue = new priorityQueue(4);
        queue.push(2);
        queue.push(6);
        queue.push(3);
        queue.push(8);
        System.out.println("优先级最高元素："+queue.pop());
        queue.push(1);
        System.out.println("优先级最高元素："+queue.pop());
    }
}
