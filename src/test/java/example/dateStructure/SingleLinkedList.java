package example.dateStructure;

public class SingleLinkedList {//单向链表
    private int size;//链表的结点个数
    private Node head;//链表的头节点

    public SingleLinkedList(){
        head = null;
        size = 0;
    }
    class Node{
        private Object value;//每个结点的数据
        private Node next;//结点的下一个结点
        public Node(Object value){
            this.value = value;
        }
    }

    //在链表头添加元素
    public void insert(Object value){
        Node node = new Node(value);
        if(head == null){
            head = node;
        }
        else {
            node.next = head;
            head = node;
        }
        size++;
    }

    //在链表头删除元素
    public Object deleteHead(){
        if(head == null){
            throw new IllegalArgumentException("链表为空");
        }
        Object object = head.value;
        head = head.next;
        size--;
        return object;
    }
    //查找指定元素，找到返回结点node，否则返回null
    public Node findNode(Object value){
        Node result = null;
        Node current = head;
        if(current == null){
            return null;
        }
        int tempSize = size;
        while (tempSize > 0){
            if(value.equals(current.value)){
                result = current;
                break;
            }
            current = current.next;
            tempSize--;
        }
        return result;
    }

    //删除指定元素
    public boolean deleteNode(Object value){
        Node current = head;
        if(current == null){
            return false;
        }
        Node before = head;
        while (!value.equals(current.value)){
            if(current.next == null){
                return false;
            }
            before = current;
            current = current.next;
        }
        if(current == head){//删除头节点
            head = head.next;
        }
        else {
            before.next = current.next;
        }
        size--;
        return true;
    }
}
