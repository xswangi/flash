package example.dateStructure;

public class SorterList {//有序链表
    private Node head;
    public SorterList(){
        head = null;
    }
    class Node {
        private Object value;//每个结点的数据
        private Node next;//结点的下一个结点

        public Node(Object value) {
            this.value = value;
        }
    }
    //插入元素
    public void insert(Object value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            return;
        }
        Node before = head;
        Node current = head;
        while (current != null && (Integer)value > (Integer)current.value){
            before = current;
            current = current.next;
        }
        before.next = node;
        node.next = current;
    }
    //删除头节点
    public void deleteHead(){
        if(head == null){
            return;
        }
        head = head.next;
    }
}
