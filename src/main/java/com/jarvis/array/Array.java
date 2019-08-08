package com.jarvis.array;

/**
 * 无序数组
 */
public class Array {

    private  String[] strArray;
    private int length=0; // 元数个数为0

    /**
     * 构造函数
     * @param max 数组长度
     */
    public Array(int max){
        strArray=new String[max];
    }

    /**
     * 检查数组中是否含有某个元素，有则返回下标，没有则返回-1
     * @param target
     * @return int
     */
    public int containts(String target){
        int index=-1;

        for (int i = 0;i < length;i++) {
            if(strArray[i].equals(target)){
                index=i;
                break;
            }
        }
        return index;
    }


    /**
     * 插入
     * @param elem
     */
    public void insert(String elem){
        strArray[length]=elem;
        length++;
    }

    /**
     * 删除元素
     * @param target
     * @return boolean
     */
    public boolean delete(String target){
        int index=-1;
        if((index=containts(target))!= -1){
            for(int i=index;i < length-1;i++){
                strArray[i]=strArray[i+1]; // index后的所有元素向前移一位
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * 列出所有元素
     */
    public void display(){
        for (int i=0;i<length;i++){
            System.out.println(strArray[i]);
        }
    }

    /**
     * 返回长度
     * @return int
     */
    public int length(){
        return strArray.length;
    }

}
