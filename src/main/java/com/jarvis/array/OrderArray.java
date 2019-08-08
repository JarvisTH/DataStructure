package com.jarvis.array;

public class OrderArray {

    private int length=0;
    private int[] orderArray;

    /**
     * 构造函数
     * @param max
     */
    public OrderArray(int max){
        orderArray=new int[max];
    }

    /**
     * 插入
     * @param target
     */
    public void insert(int target){
        int location=0;
        if(length>=orderArray.length){
            resize();
        }
        for(;location<length;location++){
            if(orderArray[location]>target){
                break;
            }
        }

        for(int i=length;i>location;i--){
            orderArray[i]=orderArray[i-1];
        }

        orderArray[location]=target;

        length++;
    }

    /**
     * 扩容，将原数组元素复制到新数组中，容量扩大到原容量的2倍
     */
    public void resize(){
        int[] newArray=new int[orderArray.length*2];
        for(int i=0;i<length;i++){
            newArray[i]=orderArray[i];
        }
        orderArray=newArray;
    }

    /**
     * 删除
     * @param target
     * @return 删除
     */
    public boolean delete(int target){
        int index=-1;

        if((index=containts(target))!=-1){
            for(int i=index;i<length;i++){
                orderArray[i]=orderArray[i+1];
            }
            length--;
            return true;
        }else {
            return false;
        }


    }

    /**
     * 检查是否存在目标元素，存在则返回下标，不存在则返回-1
     * 使用二分查找法查找
     * @param target
     * @return
     */
    public int containts(int target){
        int upperBound=length-1;
        int lowerBound=0;
        int curIndex;

        if(upperBound<0){
            return -1;
        }

        while(true){
            curIndex=(upperBound-lowerBound)/2;
            if(orderArray[curIndex]==target){
                return curIndex;
            }else if(curIndex==lowerBound){ //若当前下标与最先下标重合，表明只有1到2个元素
                if(orderArray[upperBound]==target){
                    return curIndex;
                }else {
                    return -1;
                }
            }else {
                if(orderArray[curIndex]>target){
                    upperBound=curIndex;
                }else {
                    lowerBound=curIndex;
                }
            }
        }
    }

    /**
     * 列出所有元素
     */
    public void display(){
        for(int i=0;i<length;i++){
            System.out.println(orderArray[i]);
        }
    }


}
