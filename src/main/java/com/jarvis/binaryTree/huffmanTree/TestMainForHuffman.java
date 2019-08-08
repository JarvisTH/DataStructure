package com.jarvis.binaryTree.huffmanTree;

import java.util.Iterator;
import java.util.Map;

public class TestMainForHuffman {
    public static void main(String[] args){
        PriorityQueue priorityQueue=new PriorityQueue();
        Node n1=new Node(1,"if");
        Node n2=new Node(1,"u");
        Node n3=new Node(1,"t");
        Node n4=new Node(2,"h");
        Node n5=new Node(2,"n");
        Node n6=new Node(2,"s");
        Node n7=new Node(3,"sp");
        Node n8=new Node(4,"q");
        Node n9=new Node(5,"k");
        priorityQueue.insert(n1);
        priorityQueue.insert(n2);
        priorityQueue.insert(n3);
        priorityQueue.insert(n4);
        priorityQueue.insert(n5);
        priorityQueue.insert(n6);
        priorityQueue.insert(n7);
        priorityQueue.insert(n8);
        priorityQueue.insert(n9);

        priorityQueue.display();

        HuffmanTree huffmanTree=priorityQueue.buildHuffmanTree();
        Map map=huffmanTree.getCodeSet();
        Iterator it=map.entrySet().iterator();
        System.out.println("编码结果：");
        while (it.hasNext()){
            Map.Entry<String,String> entry=(Map.Entry)it.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
