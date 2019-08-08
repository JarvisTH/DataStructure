package com.jarvis.binaryTree.binarySearchTree;


public class BinarySearchTree {
    private Node root;

    /**
     * 构造函数
     */
    public BinarySearchTree(){
        root=null;
    }

    /**
     * 插入
     * @param node
     */
    public void insert(Node node){
        if(root==null){
            root=node;
        }else {
            Node cur=root;
            while(true){
                if(node.getItem().getAge()<cur.getItem().getAge()){
                    if(cur.getLeftChild()==null){
                        cur.setLeftChild(node);
                        return;
                    }
                    cur=cur.getLeftChild();
                } else {
                    if(cur.getRightChild()==null){
                        cur.setRightChild(node);
                        return;
                    }
                    cur=cur.getRightChild();
                }
            }
        }
    }

    /**
     * 查找特点属性的节点
     * @param age
     * @return
     */
    public Node find(int age){
        if(root==null){
            return null;
        }else {
            Node cur=root;
            while(cur.getItem().getAge()!=age){
                if(age<cur.getItem().getAge()){
                    cur=cur.getLeftChild();
                }else {
                    cur=cur.getRightChild();
                }
            }
            if(cur==null){
                return null;
            }else {
                return cur;
            }
        }
    }


    /**
     * 前序打印，递归
     * @param node
     */
    public void preOrderPrint(Node node){
        if(node!=null){
            node.display();
            preOrderPrint(node.getLeftChild());
            preOrderPrint(node.getRightChild());
        }
    }

    /**
     * 中序打印，递归
     * @param node
     */
    public void middleOrderPrint(Node node){
        if(node!=null){
            middleOrderPrint(node.getLeftChild());
            node.display();
            middleOrderPrint(node.getRightChild());
        }

    }

    /**
     * 后续打印，递归
     * @param node
     */
    public void behindOrderPrint(Node node){
        if(node!=null){
            behindOrderPrint(node.getLeftChild());
            behindOrderPrint(node.getRightChild());
            node.display();
        }
    }

    /**
     * 删除指定属性节点
     * @param age
     * @return
     */
    public boolean delete(int age){
        if(root==null){
            return false;
        }

        boolean isLeftChild=true; // 标记目标节点是否是父节点的左子节点
        Node cur=root;
        Node parent=null;

        while(cur.getItem().getAge()!=age){
            parent=cur;
            if(age<cur.getItem().getAge()){
                cur=cur.getLeftChild();
            }else {
                isLeftChild=false;
                cur=cur.getRightChild();
            }
            if(cur==null){ //没有找到要删除的节点
                return false;
            }
        }

        if(cur.getLeftChild()==null&&cur.getRightChild()==null){ //没有子节点
            if(cur==root){
                root=null;
            }else if(isLeftChild){
                parent.setLeftChild(null);
            }else {
                parent.setRightChild(null);
            }
        }else if(cur.getLeftChild()==null){ //只有一个右子节点
            if(cur==root){
                root=root.getRightChild();
            }else if(isLeftChild){
                parent.setLeftChild(cur.getRightChild());
            }else{
                parent.setRightChild(cur.getRightChild());
            }
        }else if(cur.getRightChild()==null){ //只有一个左子节点
            if(cur==root){
                root=cur.getLeftChild();
            }else if(isLeftChild){
                parent.setLeftChild(cur.getLeftChild());
            }else {
                parent.setRightChild(cur.getLeftChild());
            }
        }else if(cur.getRightChild()!=null&&cur.getLeftChild()!=null){ //有两个子节点
           // 先找到其后继节点
            Node successor=cur.getRightChild();
            Node successorParent=null;
            while(successor.getLeftChild()!=null) {
                successorParent = successor;
                successor = successor.getLeftChild();
            }
            if(successorParent==null){ // 将要被删除节点的右子节点就是其后继节点，若其无左子节点，只需将其子树上移
                if(cur==root){
                    root=successor;
                    root.setLeftChild(cur.getLeftChild());
                }else if(isLeftChild){
                    parent.setLeftChild(successor);
                    successor.setLeftChild(cur.getLeftChild());
                }else {
                    parent.setRightChild(successor);
                    successor.setLeftChild(cur.getLeftChild());
                }
            }else { // 将要被删除节点不是其右子节点
                successorParent.setLeftChild(successor.getRightChild());
                successor.setRightChild(cur.getRightChild());
                if(cur==root){
                    root=successor;
                    root.setLeftChild(cur.getLeftChild());
                }else if(isLeftChild){
                    parent.setLeftChild(successor);
                    successor.setLeftChild(cur.getLeftChild());
                }else {
                    parent.setRightChild(successor);
                    successor.setLeftChild(cur.getLeftChild());
                }

            }

        }
        return true;
    }

    /**
     * 迭代获取左子树和右子树最大深度，并返回两者最大值
     * @param currentNode
     * @param initDeep
     * @return
     */
    private int getDepth(Node currentNode,int initDeep){
        int deep=initDeep; //当前已达到的深度
        int leftDeep=initDeep;
        int rightDeep=initDeep;
        if(currentNode.getLeftChild()!=null){
            leftDeep=getDepth(currentNode.getLeftChild(),deep+1);
        }
        if(currentNode.getRightChild()!=null){
            rightDeep=getDepth(currentNode.getRightChild(),deep+1);
        }

        return Math.max(leftDeep,rightDeep);
    }

    /**
     * 返回深度
     * @return
     */
    public int getTreeDepth(){
        if(root==null){
            return 0;
        }else{
            return getDepth(root,1);
        }
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty(){
        if(root==null){
            return true;
        }
        return false;
    }

    /**
     * 返回最小
     * @return
     */
    public Node getMin(){
        Node cur=root;
        if(isEmpty()){
            return null;
        }
        while(cur.getLeftChild()!=null){
            cur=cur.getLeftChild();
        }
        return cur;
    }

    /**
     * 返回最大
     * @return
     */
    public Node getMax(){
        Node cur=root;
        if(isEmpty()){
            return null;
        }
        while(cur.getRightChild()!=null){
            cur=cur.getRightChild();
        }
        return cur;
    }

    /**
     *
     * @param node
     * @return
     */
    public boolean isLeaf(Node node){
        if(node.getRightChild()==null&&node.getLeftChild()==null){
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public Node getRoot(){
        return root;
    }

}
