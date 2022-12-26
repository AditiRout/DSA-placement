package com.company;

public class evenOddll {
    public Node oddEvenList(Node head) {
        if (head != null) {

            Node odd = head, even = head.next, evenHead = even;

            while (odd.next != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;

        }
        return head;

    }
    public static void main(String[]args){

    }
}
