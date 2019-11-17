package example.dateStructure;

public class Stack {//栈--数组实现
    private static Object[] array;
    private static int maxSize;
    private static int top;

    //初始化栈
    public Stack(int size){
        maxSize = size;
        array = new Object[maxSize];
        top = -1;
    }

    //入栈
    public void push(Object value){
        if(top < maxSize - 1){
            array[++top] = value;
        }
    }

    //出栈
    public Object pop(){
        if(top != -1){
            return array[top--];
        }
        throw new IllegalArgumentException("栈为空");
    }

    //删除栈顶元素
    public Object deleteTop(){
        Object object = null;
        if(!isEmpty()){
            object = array[top];
            array[top] = null;
            top--;
        }
        return object;
    }
    //判断为空栈
    public boolean isEmpty(){
        return top == -1;
    }

    //判断栈是否已满
    public boolean isFull(){
        StringBuilder number = new StringBuilder();

        Integer n = 1;
        String s = n.toString();
        return top == maxSize - 1;
    }

    //打印栈内容
    public void output(){
        for(int i = top; i > -1;i--){
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        /*stack.push(2);
        stack.push(5);
        stack.push(8);
        stack.push(3);
        stack.output();
        stack.pop();
        stack.output();*/

        //利用栈实现字符串逆序
        String word = "welcome to China";
        Stack stack = new Stack(word.length());
        char[] chars = word.toCharArray();

        for(char c : chars){
            stack.push(c);
        }
        stack.output();
    }
}
