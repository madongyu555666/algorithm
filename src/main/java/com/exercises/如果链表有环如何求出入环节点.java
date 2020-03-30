package com.exercises;

/**
 * https://segmentfault.com/a/1190000015308120
 */
public class 如果链表有环如何求出入环节点 {
    private static  class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }



    public  static Node isCycle(Node head){
       Node p1=head;
        Node p2=head;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                break;
            }
        }
        if(p2 == null || p2.next == null){
            return null;
        }
        // 有环，slow重新回到链表头
        p1 = head;
        // slow和fast重新相遇时，相遇节点就是入环节点
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
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
        System.out.println(cycle.data);
    }
}
