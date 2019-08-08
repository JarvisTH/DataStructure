package com.jarvis.link;

public class TestMainForLinkList {
    public static void main(String[]  args){
        LinkList linkList=new LinkList();
        Item item=new Item();
        item.setAge(18);
        item.setName("jarvis");
        Link link=new Link(item);
        linkList.insert(link);
        item=new Item();
        item.setAge(20);
        item.setName("jarvis");
        link=new Link(item);
        linkList.insert(link);
        item=new Item();
        item.setAge(22);
        item.setName("jarvis");
        link=new Link(item);
        linkList.insert(link);
        item=new Item();
        item.setAge(15);
        item.setName("jarvis");
        link=new Link(item);
        linkList.insert(link);
        item=new Item();
        item.setAge(10);
        item.setName("jarvis");
        link=new Link(item);
        linkList.insert(link);
        linkList.display();

        try{
            linkList.deleteFirst();
        }catch (Exception e){

        }
        linkList.display();

    }
}
