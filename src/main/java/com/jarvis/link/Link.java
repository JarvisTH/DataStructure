package com.jarvis.link;

public class Link {
    public Item item;
    public Link next;

    /**
     * 构造方法
     * @param item
     */
    public Link(Item item){
        this.item=item;
        next=null;
    }

    public void display(){
        System.out.println("age："+item.getAge()+", name:"+item.getName());
    }

}
