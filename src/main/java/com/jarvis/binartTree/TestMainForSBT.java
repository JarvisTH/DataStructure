package com.jarvis.binartTree;

import com.jarvis.link.Item;

public class TestMainForSBT {
    public static void main(String[] args){
        BinarySearchTree binarySearchTree=new BinarySearchTree();

//        for(int i=0;i<10;i++){
//            Item item=new Item();
//            item.setAge((int)(Math.random()*100));
//            item.setName("jarvis");
//            Node node=new Node(item);
//            binarySearchTree.insert(node);
//        }
//
        Item item=new Item();
        item.setAge(10);
        item.setName("jarvis");
        Node node=new Node(item);
        binarySearchTree.insert(node);

        item=new Item();
        item.setAge(15);
        item.setName("jarvis");
        node=new Node(item);
        binarySearchTree.insert(node);

        item=new Item();
        item.setAge(43);
        item.setName("jarvis");
        node=new Node(item);
        binarySearchTree.insert(node);

        item=new Item();
        item.setAge(5);
        item.setName("jarvis");
        node=new Node(item);
        binarySearchTree.insert(node);

        item=new Item();
        item.setAge(46);
        item.setName("jarvis");
        node=new Node(item);
        binarySearchTree.insert(node);

        item=new Item();
        item.setAge(2);
        item.setName("jarvis");
        node=new Node(item);
        binarySearchTree.insert(node);

        item=new Item();
        item.setAge(4);
        item.setName("jarvis");
        node=new Node(item);
        binarySearchTree.insert(node);

        item=new Item();
        item.setAge(24);
        item.setName("jarvis");
        node=new Node(item);
        binarySearchTree.insert(node);

        binarySearchTree.middleOrderPrint(binarySearchTree.getRoot());

       System.out.println(binarySearchTree.getTreeDepth());

    }
}
