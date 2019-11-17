package com.springboot.demo.sort;

import java.util.LinkedList;
import java.util.List;

public class Tree {//二叉树
    private static List<Node> linkedList;

    class Node{
        private Node leftChild;
        private Node rightChild;
        private int value;
        public Node(int value){
            leftChild=null;
            rightChild=null;
            this.value=value;
        }
    }
    //构建一棵二叉树
    public void createTree(int[] array){
        linkedList = new LinkedList<>();
        for(int i=0;i<array.length;i++){
            linkedList.add(new Node(array[i]));
        }
        //梳理最后一个父节点之前的父节点结点关系
        int parentNode = array.length / 2;//所有父节点
        for(int pNode = 0;pNode < parentNode - 1;pNode++){
            linkedList.get(pNode).leftChild = linkedList.get(pNode*2 + 1);
            linkedList.get(pNode).rightChild = linkedList.get(pNode*2 + 2);
        }
        //最后一个父节点
        int lastPnode = parentNode - 1;
        linkedList.get(lastPnode).leftChild = linkedList.get(lastPnode * 2 + 1);
        if(array.length%2 == 1){
            linkedList.get(lastPnode).rightChild = linkedList.get(lastPnode * 2 + 2);
        }
    }

    //前序遍历二叉树
    public void firstoutPut(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+" ");
        firstoutPut(node.leftChild);
        firstoutPut(node.rightChild);
    }

    //中序遍历二叉树
    public void middleoutput(Node node){
        if(node == null){
            return;
        }

        middleoutput(node.leftChild);
        System.out.print(node.value+" ");
        middleoutput(node.rightChild);
    }

    //后序遍历
    public void afteroutput(Node node){
        if(node == null){
            return;
        }
        afteroutput(node.leftChild);
        afteroutput(node.rightChild);
        System.out.print(node.value+" ");
    }

    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        Tree tree = new Tree();
        tree.createTree(array);
        tree.firstoutPut(tree.linkedList.get(0));
        System.out.println();
        tree.middleoutput(tree.linkedList.get(0));
        System.out.println();
        tree.afteroutput(tree.linkedList.get(0));
    }

}
