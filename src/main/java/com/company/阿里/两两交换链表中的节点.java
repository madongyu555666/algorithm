package com.company.阿里;

/**
 * @author madongyu
 * @title: 两两交换链表中的节点
 * @projectName algorithm
 * @description: TODO
 * @date 2020/4/214:29
 */
public class 两两交换链表中的节点 {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *  
     *
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    /**
     *时间复杂度：o(n),空间复杂度:O(N)
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
         if(head==null||head.next==null){
             return head;
         }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next=head;
        return next;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode listNode = swapPairs(node1);
        System.out.println(listNode);

    }

}
