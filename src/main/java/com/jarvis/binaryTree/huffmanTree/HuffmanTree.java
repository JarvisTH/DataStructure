package com.jarvis.binaryTree.huffmanTree;

import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {
    private Node root;
    private Map codeSet=new HashMap();//霍夫曼树对应的编码集

    /**
     * 构造函数
     * @param root
     */
    public HuffmanTree(Node root){
        this.root=root;
        buildCodeSet(root,""); //初始化编码集
    }

    /**
     * 迭代生成编码
     * @param currentNode
     * @param currentCode
     */
    public void buildCodeSet(Node currentNode,String currentCode){
        if(currentNode.getKey()!=null){
            //霍夫曼树中，如果当前节点包含关键字，则该节点肯定是叶子节点，将其关键字和编码放入编码集
            codeSet.put(currentNode.getKey(),currentCode);
        }else { //不是叶子节点，必定包含左右子节点
            //转向左子节点需要将当前编码追加0
            buildCodeSet(currentNode.getLeftChild(),currentCode+"0");
            //转向左子节点需要将当前编码追加1
            buildCodeSet(currentNode.getRightChild(),currentCode+"1");
        }
    }

    /**
     * 获取编码集
     * @return
     */
    public Map getCodeSet(){
        return codeSet;
    }


}
