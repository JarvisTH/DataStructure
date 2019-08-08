package com.jarvis.stack;

public class Stack {
    private int size;
    private int top;
    private char[] stack;

    /**
     * 构造函数
     * @param size
     */
    public Stack(int size){
        this.size=size;
        stack=new char[size];
        top=-1; //初始化栈时，站内元素为空
    }

    /**
     * 入栈
     * @param target
     */
    public void push(char target){
        stack[++top]=target;
    }

    /**
     * 出栈
     * @return char
     */
    public char pop(){
        return stack[top--];
    }

    /**
     * 查看栈顶元素
     * @return int
     */
    public char peek(){
        return stack[top];
    }

    /**
     * 判空
     * @return boolean
     */
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull(){
        if(top==size-1){
            return true;
        }else {
            return false;
        }
    }

}
