package example.dateStructure;

public class DoubleList {//双端链表
    private Node head;//头节点
    private Node tail;//尾节点
    private int size;//结点的个数

    public DoubleList(){
        head = null;
        tail = null;
        size = 0;
    }

    class Node{
        private Object value;//每个结点的数据
        private Node next;//结点的下一个结点
        public Node(Object value){
            this.value = value;
        }
    }

    //在链表头插入数据
    public void insertHead(Object value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
            size++;
        }
        else {
            node.next = head;
            head = node;
            size++;
        }
    }
    //链表尾新增结点
    public void insertTail(Object value){
        Node node = new Node(value);
        if(tail == null){
            head = node;
            tail = node;
            size++;
        }
        else {
            tail.next = node;
            tail = node;
            size++;
        }
    }
    //删除头部结点
    public boolean deleteHead(){
        if(size == 0){
            return false;
        }
        if(head.next == null){
            head = null;
            tail = null;
        }
        else {
            head = head.next;
        }
        size--;
        return true;
    }
}
