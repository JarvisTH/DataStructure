package com.jarvis.link;

public class OrderLinkList {
    private Link first;

    public OrderLinkList(){
        first=null;
    }

    /**
     * 插入链表
     * @param link
     */
    public void insert(Link link){
        Link cur=first;
        Link pre=null;
        if(cur==null){
            first=link;
            return;
        }
        while(cur!=null){
            if(cur.item.getAge()<link.item.getAge()){
                pre=cur;
                cur=cur.next;
            }else {
                break;
            }
        }
        if(pre==null){
            link.next=cur;
            first=link;
        }else {
            pre.next=link;
            link.next=cur;
        }
    }

    /**
     * 删除头节点
     * @return
     * @throws Exception
     */
    public Link deleteFirst()throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空，不能进行删除！");
        }
        Link link=first;
        first=first.next;
        return link;
    }

    /**
     * 打印链表
     */
    public void display(){
        Link cur=first;
        while(cur!=null){
            cur.display();
            cur=cur.next;
        }
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty(){
        if(first==null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除指定属性节点
     * @param item
     * @return
     */
    public Link delete(Item item){
       Link cur=first;
       Link pre=null;
       while(cur!=null){
           if(cur.item.getAge()!=item.getAge()){
               pre=cur;
               cur=cur.next;
           }else {
               break;
           }
       }
       if(pre==null&&first!=null){
           first=cur.next;
       }else if(pre!=null&&cur==null){
           return null;
       }else if (pre!=null&&cur!=null){
           pre.next=cur.next;
       }
        return cur;
    }

    /**
     * 查找指定元素的节点
     * @param item
     * @return
     */
    public Link find(Item item){
        Link cur=first;
        Link temp=null;
        while(cur!=null){
            if(cur.item.getAge()==item.getAge()&&cur.item.getName().equals(item.getName())){
                temp=cur;
            }else {
                cur=cur.next;
            }
        }
        return temp;
    }
}
