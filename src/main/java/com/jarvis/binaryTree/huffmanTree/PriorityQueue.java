package com.jarvis.binaryTree.huffmanTree;

public class PriorityQueue {
    private Node first;
    private int length;

    /**
     * 构造函数
     */
    public PriorityQueue(){
        length=0;
        first=null;
    }

    /**
     * 插入元素
     * @param node
     */
    public void insert(Node node){
        if(first==null){
            first=node;
        }else {
            Node cur=first;
            Node pre=null;
            while(cur.getFrequency()<node.getFrequency()){
                pre=cur;
                if(cur.getNext()==null){
                    cur=null;
                    break;
                }else {
                    cur=cur.getNext();
                }
            }
            if(pre==null){
                node.setNext(first);
                first=node;
            }else if(cur==null){
                pre.setNext(node);
            }else {
                pre.setNext(node);
                node.setNext(cur);
            }
        }
        length++;
    }

    /**
     * 删除队头元素
     * @return
     */
    public Node delete(){
        Node temp=first;
        first=first.getNext();
        length--;
        return temp;
    }

    /**
     * 获取队列长度
     * @return
     */
    public int getLength(){
        return length;
    }

    /**
     * 打印
     */
    public void display(){
        Node cur=first;
        System.out.println("优先级队列：");
        while(cur!=null){
            System.out.print(cur.getKey()+":"+cur.getFrequency()+"\t");
            cur=cur.getNext();
        }
        System.out.println();
    }

    /**
     * 构造霍夫曼树
     * @return
     */
    public HuffmanTree buildHuffmanTree(){
        while(length>1){
            Node left=delete();
            Node right=delete();

            Node root=new Node(left.getFrequency()+right.getFrequency());
            root.setLeftChild(left);
            root.setRightChild(right);
            insert(root);
        }
        //最后队列中只剩一个节点，即为根节点
        return new HuffmanTree(first);
    }
}
