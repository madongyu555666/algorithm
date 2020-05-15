package com.jikeshijian.tanchao;

import com.company.字节跳动.反转链表;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 反转一个单链表
 * @date 2020/5/816:41
 */
public class 反转一个单链表 {
    static class ListNode{
        int val;
        反转一个单链表.ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        反转一个单链表.ListNode node1=new 反转一个单链表.ListNode(1);
        反转一个单链表.ListNode node2=new 反转一个单链表.ListNode(2);
        反转一个单链表.ListNode node3=new 反转一个单链表.ListNode(3);
        反转一个单链表.ListNode node4=new 反转一个单链表.ListNode(4);
        反转一个单链表.ListNode node5=new 反转一个单链表.ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode li= reverseList(node1);
        while (li!=null){
            System.out.print(li.val+" ");
            li=li.next;
        }
    }
}
