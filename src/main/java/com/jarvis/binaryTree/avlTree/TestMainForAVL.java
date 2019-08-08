package com.jarvis.binaryTree.avlTree;

public class TestMainForAVL {
    public static void main(String[] args){
        AVLTree avlTree=new AVLTree();
        int[] array=new int[15];
        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*1000);
            System.out.print(array[i]+"\t");
        }
        System.out.println();
        for(int a:array){
            avlTree.insert(a);
        }
        proOrder(avlTree.getRoot());
    }

    /**
     * 前序
     * @param currentRoot
     */
    public static void proOrder(AVLTreeNode currentRoot){
        if(currentRoot!=null){
            System.out.println(currentRoot.value+"\t");
            proOrder(currentRoot.left);
            proOrder(currentRoot.right);
        }
    }
}
