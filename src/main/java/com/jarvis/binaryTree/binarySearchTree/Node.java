package com.jarvis.binaryTree.binarySearchTree;

import com.jarvis.link.Item;

public class Node {
    private Item item;
    private Node leftChild;
    private Node rightChild;

    /**
     * 构造方法
     * @param item
     */
    public Node(Item item){
        this.item=item;
        leftChild=null;
        rightChild=null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * 打印
     */
    public void display(){
        System.out.println(item.getAge()+", "+item.getName());
    }
}
