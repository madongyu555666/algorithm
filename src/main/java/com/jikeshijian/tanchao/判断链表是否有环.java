package com.jikeshijian.tanchao;

import com.exercises.判断是否有环;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2020/5/817:40
 */
public class 判断链表是否有环 {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 时间复杂度：O(n),空间复杂度O(n)
     * @param head
     * @return
     */
    public  static  boolean isCycle(ListNode head){
        ListNode p1=head;
        ListNode p2=head;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        判断链表是否有环.ListNode node1=new 判断链表是否有环.ListNode(5);
        判断链表是否有环.ListNode node2=new 判断链表是否有环.ListNode(3);
        判断链表是否有环.ListNode node3=new 判断链表是否有环.ListNode(7);
        判断链表是否有环.ListNode node4=new 判断链表是否有环.ListNode(2);
        判断链表是否有环.ListNode node5=new 判断链表是否有环.ListNode(6);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node2;


        System.out.println(isCycle(node1));
    }
}
