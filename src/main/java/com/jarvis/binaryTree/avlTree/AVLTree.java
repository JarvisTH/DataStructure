package com.jarvis.binaryTree.avlTree;

public class AVLTree {
    private AVLTreeNode root;

    /**
     * 返回函数
     * @return
     */
    public AVLTreeNode getRoot() {
        return root;
    }

    /**
     * 插入函数入口
     * @param insertValue
     */
    public void insert(long insertValue){
        root=insert(root,insertValue);
    }

    /**
     * 插入函数递归实现
     * @param subTree
     * @param insertValue
     * @return
     */
    private AVLTreeNode insert(AVLTreeNode subTree,long insertValue) {
        if (subTree == null) {
            return new AVLTreeNode(insertValue, null, null);
        }

        if (insertValue < subTree.value) {  //插入左子树
            subTree.left = insert(subTree.left, insertValue);
            if (unbalanceTest(subTree)) { //插入后失衡
                if (insertValue < subTree.left.value) { //LL型
                    subTree = leftLeftRotation(subTree);
                } else { //LR型
                    subTree = leftRightRotation(subTree);
                }
            }
        } else if (insertValue > subTree.value) { //插入右子树
            subTree.right = insert(subTree.right, insertValue);
            if (unbalanceTest(subTree)) {
                if (insertValue < subTree.right.value) { //RL型
                    subTree = rightLeftRotation(subTree);
                } else { //RR型
                    subTree = rightRightRotation(subTree);
                }
            }
        } else {
            throw new RuntimeException("duplicate value:" + insertValue);
        }
        return subTree;
    }

    /**
     * RL型
     * @param k1
     * @return
     */
    private AVLTreeNode rightLeftRotation(AVLTreeNode k1) {
        k1.right=leftLeftRotation(k1.right);
        return rightLeftRotation(k1);
    }

    /**
     * RR型
     * @param k1
     * @return
     */
    private AVLTreeNode rightRightRotation(AVLTreeNode k1){
        AVLTreeNode k2;

        k2=k1.right;
        k1.right=k2.left;
        k2.left=k1;

        return k2;
    }

    /**
     * LR型
     * @param k3
     * @return
     */
    private AVLTreeNode leftRightRotation(AVLTreeNode k3){
        k3.left=rightRightRotation(k3.left);

        return leftLeftRotation(k3);
    }

    /**
     * LL型
     * @param k2
     * @return
     */
    private AVLTreeNode leftLeftRotation(AVLTreeNode k2){
        AVLTreeNode k1;

        k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;

        return k1;
    }


    /**
     * 获取树深度
     * @param treeRoot
     * @param initDeep
     * @return
     */
    public int getDepth(AVLTreeNode treeRoot,int initDeep){
        if(treeRoot==null){
            return initDeep;
        }
        int leftDeep=initDeep;
        int rightDeep=initDeep;
        if(treeRoot.left!=null){
            leftDeep=getDepth(treeRoot.left,initDeep);
        }
        if(treeRoot.right!=null){
            rightDeep=getDepth(treeRoot.right,initDeep);
        }

        return Math.max(leftDeep,rightDeep);
    }

    /**
     * 测试是否平衡
     * @param treeRoot
     * @return
     */
    public boolean unbalanceTest(AVLTreeNode treeRoot){
        int leftHight=getDepth(treeRoot.left,1);
        int rightHight=getDepth(treeRoot.right,1);
        int diff=Math.abs(leftHight-rightHight);
        return diff>1;
    }

    /**
     * remove函数入口
     * @param value
     */
    public void remove(long value){
        root=remove(root,value);
    }

    /**
     * 删除函数递归实现
     * @param tree
     * @param value
     * @return
     */
    private AVLTreeNode remove(AVLTreeNode tree,long value){
        if(tree==null){
            return tree;
        }
        if(value<tree.value){ //要删除的节点在左子树
            tree.left=remove(tree.left,value);
        }else if(value>tree.value){ //要删除的节点在右子树上
            tree.right=remove(tree.right,value);
        }else if(tree.value==value){ //删除本身
            if(tree.left!=null && tree.right!=null){
                if(getDepth(tree.left,1)>getDepth(tree.right,1)){
                    /**
                     * 如果tree的左子树比右子树高
                     * 1.找出tree的左子树最大节点
                     * 2.将其值赋值给tree
                     * 3.删除该最大节点
                     * 类似于用“tree的左子树最大节点”做tree的替身
                     * 好处是“删除tree的左子树中最大节点”后，AVL树仍然是平衡的
                     */
                    AVLTreeNode max=getMaxNode(tree.left);
                    tree.value=max.value;
                    tree.left=remove(tree.left,max.value);
                }else{
                        AVLTreeNode min=getMinNode(tree.right);
                        tree.value=min.value;
                        tree.right=remove(tree.right,min.value);
                }
            }else {
                System.out.println("no node matched value"+value);
            }
        }
        return tree;
    }

    /**
     * 找到值最大节点
     * @param node
     * @return
     */
    private AVLTreeNode getMaxNode(AVLTreeNode node){
        if(node==null){
            return null;
        }

        if(node.right!=null){
            return getMaxNode(node.right);
        }else {
            return node;
        }
    }

    /**
     * 找到值最小节点
     * @param node
     * @return
     */
    private AVLTreeNode getMinNode(AVLTreeNode node){
        if(node==null){
            return null;
        }
        if(node.left==null){
            return getMinNode(node.left);
        }else {
            return node;
        }
    }


}
