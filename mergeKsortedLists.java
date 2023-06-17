package com.company;

import java.util.PriorityQueue;

public class mergeKsortedLists {
    public Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq=new PriorityQueue<>((o1, o2)->(o1.val-o2.val));
        for(Node l:lists){
            if(l!=null){

                pq.offer(l);
            }
        }

        Node ans=new Node(-1);
        Node curr=ans;
        while(!pq.isEmpty()){
            curr.next=pq.poll();
            curr=curr.next;
            if(curr.next!=null){
                pq.offer(curr.next);
            }
        }
        return ans.next;

    }
}
