package com.exercises;

public class 如果链表有环如何求出长度呢 {
    private static  class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }



    public  static  Node isCycle(Node head){
        Node p1=head;
        Node p2=head;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                return p1;
            }
        }
        return null;
    }

    /**
     * 传入的是相遇的点
     * @param head
     * @return
     */
    public  static  int  advanceTimes(Node head){
        if (head == null) {
            return 0;
        }
        Node current = head;
        int length = 0;
        while (current!=null){
            current = current.next;
            length++;
            if(current==head){
                return length;
            }
        }
        return length;

    }





    public static void main(String[] args) {
        Node node1=new Node(5);
        Node node2=new Node(3);
        Node node3=new Node(7);
        Node node4=new Node(2);
       Node node5=new Node(6);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node2;
        Node cycle = isCycle(node1);
        System.out.println(advanceTimes(cycle));
    }
}
