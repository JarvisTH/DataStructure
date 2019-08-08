package com.jarvis.stack;

public class BrecketChecker {
    private String input;

    /**
     * 构造函数
     * @param input
     */
    public BrecketChecker(String input){
        this.input=input;
    }

    /**
     * 检查括号是否匹配
     * @return
     */
    public void check(){
        int strLength=input.length();
        Stack stack=new Stack(strLength);

        for(int i=0;i<strLength;i++){
            char ch=input.charAt(i);
            switch (ch){
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!stack.isEmpty()){
                        char chx=stack.pop();
                        if((ch=='}'&&chx!='{')||
                        ch==']'&&chx!='['||
                        ch==')'&&chx!='('){
                    System.out.println("ERROR,字符："+ch+",下标"+i);
                }
            }else {
                System.out.println("ERROR,字符："+ch+",下标"+i);
            }
                    default:
                        break;
            }
        }
        if(!stack.isEmpty()){
            System.out.println("有括号没有关闭");
        }
    }
}
