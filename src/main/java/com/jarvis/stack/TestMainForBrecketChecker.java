package com.jarvis.stack;

public class TestMainForBrecketChecker {
    public static void main(String[] args){
        String str="(9[8{6}])";
        BrecketChecker checker=new BrecketChecker(str);
        checker.check();
        str="9(88[6545{5454}]{";
        BrecketChecker checker1=new BrecketChecker(str);
        checker1.check();
    }
}
