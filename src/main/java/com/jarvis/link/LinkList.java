package com.jarvis.link;

public class LinkList {
    private Link first;

    public LinkList(){
        first=null;
    }

    /**
     * 插入链表，头插法
     * @param link
     */
    public void insert(Link link){
        link.next=first;
        first=link;
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
        Link temp=null;
        Link cur=first;
        Link next=first.next;
        Link pre=null;
        while(cur!=null){
            if(cur.item.getName().equals(item.getName())&&cur.item.getAge()==item.getAge()){
                temp=first;
                if(pre==null){
                    this.first=next;
                }else {
                    pre.next=next;
                }
                break;
            }else if(cur.next==null){
                break;
            }

            next=next.next;
            cur=pre;
            cur=cur.next;

        }
        return temp;
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
