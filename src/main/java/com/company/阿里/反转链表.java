package com.company.阿里;


/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class 反转链表 {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
    　　* @description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author madongyu
    　　* @date
    　　*/
    public static ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode next=null;
        while (head!=null){
            next = head.next;
            head.next=pre;
            pre=head;
            head=next ;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        reverseList(node1);

    }



}
