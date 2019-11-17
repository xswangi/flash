package example.dateStructure;

public class StackOfList {//单向链表实现栈
    private SingleLinkedList linkedList;
    public StackOfList(){
        linkedList = new SingleLinkedList();
    }

    public void push(Object value){
        linkedList.insert(value);
    }
    public void pop(){
        linkedList.deleteHead();
    }
}
