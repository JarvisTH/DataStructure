package com.jarvis.binaryTree.avlTree;

public class AVLTreeNode {
    long value; //存储节点数值
    AVLTreeNode left;
    AVLTreeNode right;

    public AVLTreeNode(long value,AVLTreeNode left,AVLTreeNode right){
        this.left=left;
        this.right=right;
        this.value=value;
    }

    public long getValue(){
        return this.value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }
}
