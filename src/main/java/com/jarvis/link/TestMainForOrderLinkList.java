package com.jarvis.link;

import com.jarvis.array.OrderArray;

public class TestMainForOrderLinkList {
    public static void main(String[] args){
        OrderLinkList orderLinkList=new OrderLinkList();
        Item item=new Item();
        item.setAge(18);
        item.setName("jarvis");
        Link link=new Link(item);
        orderLinkList.insert(link);
        item=new Item();
        item.setAge(15);
        item.setName("jarvis");
        link=new Link(item);
        orderLinkList.insert(link);
        item=new Item();
        item.setAge(20);
        item.setName("jarvis");
        link=new Link(item);
        orderLinkList.insert(link);
        item=new Item();
        item.setAge(10);
        item.setName("jarvis");
        link=new Link(item);
        orderLinkList.insert(link);
        item=new Item();
        item.setAge(40);
        item.setName("jarvis");
        link=new Link(item);
        orderLinkList.insert(link);
        orderLinkList.display();
        System.out.println("下面是删除一个元素打印结果");
        item=new Item();
        item.setAge(20);
        item.setName("jarvis");
        orderLinkList.delete(item);
        orderLinkList.display();
    }
}
