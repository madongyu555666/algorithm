package com.jikeshijian.tanchao;

import java.util.List;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 25题
 * @date 2020/5/918:48
 */
public class K个一组翻转链表 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
         ListNode dummy=new ListNode(0);
         dummy.next=head;

        ListNode pre=dummy;
        ListNode end= dummy;

        while (end.next != null){
            for (int i=0;i<k&&end!=null;i++) {
                end=end.next;
            }
            if(end==null){
                break;
            }
            ListNode start =pre.next;
            ListNode next =end.next;
            end.next=null;
            pre.next = reverse(start);
            start.next=next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    //反转
    private static ListNode reverse(ListNode head) {
       ListNode pre=null;
       ListNode curr=head;
       while (curr != null){
           ListNode next = curr.next;
           curr.next=pre;
           pre=curr;
           curr=next;
       }
       return pre;
    }


    public static void main(String[] args) {
        /*[1,2,3,4,5]
2*/
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;

        ListNode listNode = reverseKGroup(node1, 2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
