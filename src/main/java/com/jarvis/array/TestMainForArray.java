package com.jarvis.array;

public class TestMainForArray {
    private static final int ARRAY_SIEZ=10;

    public static void main(String[] args){
        Array array=new Array(ARRAY_SIEZ);
        array.insert("my");
        array.insert("what");
        array.insert("test");
        array.insert("who");
        array.display();
        array.delete("my");
        array.display();
        System.out.println(array.containts("me"));
    }
}
