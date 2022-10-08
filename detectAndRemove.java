package com.company;

public class detectAndRemove {
    public boolean detectCycle(Node hd){
        Node slow=hd;
        Node fast=hd;
        while(fast!=null || fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(Node hd){
        Node slow=hd;
        Node fast=hd;
        do{
            slow=slow.next;
            fast=fast.next;
        }while(slow==fast);
        fast=hd;
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=null;
    }

    public static void main(String[]args){
        Node head=new Node("2");
        



    }

}
