package com.jarvis.binaryTree.huffmanTree;

import com.jarvis.link.Item;

public class Node {
    private String key; //存储关键字，若是非叶子节点为空
    private int frequency; //关键字词频
    private Node leftChild;
    private Node rightChild;
    private Node next; //优先级队列中指向下一节点

    public Node(int fre,String str){
        this.key=str;
        this.frequency=fre;
    }

    public Node(int frequency){
        this.frequency=frequency;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
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

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
