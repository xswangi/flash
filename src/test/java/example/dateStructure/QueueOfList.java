package example.dateStructure;

public class QueueOfList {//双端链表实现队列
    private DoubleList doubleList;
    public QueueOfList(){
        doubleList = new DoubleList();
    }

    //入队
    public void insert(Object value){
        doubleList.insertTail(value);
    }
    //出队
    public void delete(){
        doubleList.deleteHead();
    }
}
