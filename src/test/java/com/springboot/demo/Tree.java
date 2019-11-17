package com.springboot.demo;
import java.util.LinkedList;
import java.util.List;

public class Tree {//二叉树
    private static int[] array = new int[]{1,2,3,4,5,6,7,8,9};
    private static List<Node> nodeList = null;

    /**
     * 内部类：结点
     * */
    private static class Node{
        Node leftChild;
        Node rightChild;
        int data;
        Node(int newData){
            data = newData;
            leftChild = null;
            rightChild = null;
        }
    }

    //创建二叉树（父结点数量为n/2）
    public static void createBinTree(){
        nodeList = new LinkedList<Node>();
        //将数组的值转为Node结点
        for(int index = 0;index < array.length; index++ ){
            nodeList.add(new Node(array[index]));
        }
        //对前lastParentIndex-1个父结点与孩子结点的数字关系建立二叉树(n/2 -1)
        for(int parentIndex = 0;parentIndex < array.length/2 -1;parentIndex++){
            //左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            //右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }
        //插入最后一个父结点，由于不确定最后一个父结点有没有右孩子，所以单独处理
        int lastParentIndex = array.length/2 - 1;
        //最后一个父结点的左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);
        //右孩子
        if(array.length % 2 == 1){
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
        }
    }

    /**
     * 先序遍历
     * */
    public static void preOrderTravelse(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrderTravelse(node.leftChild);
        preOrderTravelse(node.rightChild);
    }

    /**
     * 中序遍历
     * */
    public static void inOrderTraverse(Node node){
        if(node == null){
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     * */
    public static void postOrderTraverse(Node node){
        if(node == null){
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    //main方法
    public static void main(String[] args){
        createBinTree();
        //nodeList中第0个索引处的值即为根结点
        Node node = nodeList.get(0);
        System.out.print("前序遍历结果为：");
        preOrderTravelse(node);
        System.out.println();
        System.out.print("中序遍历结果为：");
        inOrderTraverse(node);
        System.out.println();
        System.out.print("后续遍历结果为：");
        postOrderTraverse(node);
    }
}
