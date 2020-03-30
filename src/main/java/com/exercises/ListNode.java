package com.exercises;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2020/3/2418:00
 */
public class ListNode {
    int val;
      ListNode next;
     ListNode(int x) { val = x; }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
