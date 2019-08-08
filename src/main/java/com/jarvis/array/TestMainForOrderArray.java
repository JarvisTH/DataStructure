package com.jarvis.array;

public class TestMainForOrderArray {
    private static final  int SIZE=10;

    public static void main(String[] args){
        OrderArray array=new OrderArray(SIZE);
        array.insert(5);
        array.insert(4);
        array.insert(8);
        array.insert(7);
        array.insert(0);
        System.out.println("插入后打印：");
        array.display();
        array.delete(5);
        System.out.println("删除后打印：");
        array.display();
        array.insert(-1);
        System.out.println("插入后打印：");
        array.display();
        array.insert(0);
        array.insert(0);
        array.insert(0);
        array.insert(0);
        array.insert(0);
        array.insert(0);
        array.insert(0);
        array.insert(0);
        array.insert(0);
        System.out.println("插入超过容量的数值个数后：");
        array.display();
    }
}
