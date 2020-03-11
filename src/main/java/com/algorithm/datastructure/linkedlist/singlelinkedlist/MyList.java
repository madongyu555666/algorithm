package com.algorithm.datastructure.linkedlist.singlelinkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表
 */
public class MyList {
    /**
     * 头结点的插入
     */
    public static void headInsert(Node head,Node newhead){
        Node old =head;
        head =newhead;
        head.next=old;
    }

    /**
     * 尾结点的插入
     */
    public static void tailInsert(Node tail,Node newtail){
        Node old =tail;
        tail =newtail;
        tail.next=null;
        old.next=tail;
    }

    /**
     *  遍历
     */
    public static void traverse(Node head){
        while (head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }
        System.out.println();
    }


    /**
     *  查找
     */
    public static int find(Node head,int value){
       int index= -1 ;
       int count = 0;
       while (head !=null){
           if(head.value==value){
               index=count;
               return index;
           }
           count++;
           head=head.next;
       }
       return index;
    }

    /**
     * 插入
     */
    public static void insert(Node p,Node s){
        Node next=p.next;
        p.next=s;
        s.next=next;
    }

    /**
     * 删除
     */
    public static void delete(Node head,Node q){
        if(head!=null&& q.next!=null){
            Node p=q.next;
            q.value=p.value;
            q.next=p.next;
            p=null;
        }
        //如果删除的是最后一个元素
        if(q.next==null){
            while (head!=null){
                if(head.next!=null&&head.next==q){
                    head.next=null;
                    break;
                }
                head=head.next;
            }
        }
    }


    /**
     * 反转链表
     *
     */
     public static Node reverseList(Node head){
       Node pre=null; //当前节点的上一个
       Node next=null;//当前节点的下一个
       while (head!=null){
           next=head.next;
           head.next=pre;
           pre=head;
           head=next;
       }
       return pre;
     }


    /**
     * 取中间节点（偶数个）
     *
     */
    public static Node getMid(Node head){
        if(head==null){
            return head;
        }
        Node fast=head;
        Node slow=head;

        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow;
    }

    /**
     * 合并两个有序链表，方法一：递归
     * @param
     */
    public  static Node mergeTwoList(Node head1,Node head2){
        if(head1 == null && head2 == null){
            return null;
        }
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node head= null;
        if(head1.value>head2.value){
            head=head2;
            head.next = mergeTwoList(head1,head2.next);
        }else {
            head=head1;
            head.next=mergeTwoList(head1.next,head2);
        }
        return head;
    }


    /**
     * 合并两个链表不适用递归
     * @param
     */
    public static  Node mergeTwoList2(Node head1,Node head2){
        if(head1 == null || head2 == null){
           return head1!=null ? head1:head2;
        }
        Node head= head1.value<head2.value ? head1:head2;
        Node cur1= head == head1 ? head1 : head2;
        Node cur2= head == head1 ? head2 : head1;

        //把大的链表合并进小的链表中
        Node pre= null;//前一个元素
        Node next = null;//后一个元素
        while(cur1!=null && cur2 !=null){
            if(cur1.value<=cur2.value){
                pre = cur1;
                cur1 = cur1.next;
            }else {
                pre = cur2;
                cur2 = cur2.next;
                pre.next=cur2;
                cur2.next = cur1;
            }

        }
        pre.next=cur1==null?cur2:cur1;
        return head;

    }


    /*public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        node1.next=node2;
        node3.next=node4;
        Node node= mergeTwoList2(node1,node3);
        while (node!=null){
            System.out.print(node.value+" ");
            node =node.next;
        }
    }*/


    /**
     *一个链表，奇数位升序，偶数位降序，对该链表进行排序
     * 1 8 3 6 5 4 7 2 9
     * 1 2 3 4 5 6 7 8 9
     * O(n)
     */

    /**
     *
     * 分成三步
     * 1.按照奇数位和偶数位拆分成两个链表
     * 2.对偶数位链表进行反转
     * 3. 将两个有序链表进行合并
     */
    public static Node[] getNode1(Node head){
        Node head1 = null;
        Node head2 = null;

        Node cur1 = null; //奇数链表
        Node cur2 = null; //偶数链表

        int count = 1 ; //用来计数

        while(head != null){
            if(count % 2== 1){
                if(cur1!= null){
                    cur1.next=head;
                    cur1=cur1.next;
                }else {
                    cur1 = head;
                    head1 = cur1;
                }
            }else {
                //偶数
                if(cur2 !=null){
                   cur2.next=head;
                   cur2  = cur2.next;
                }else {
                    cur2 = head;
                    head2 = cur2;
                }
            }
            head = head.next;
            count++;
        }
        cur1.next=null;
        cur2.next=null;

        Node[] nodes=new Node[]{head1,head2};
        return nodes;
    }

    /**
     * 2.对偶数位链表进行反转
     * @param
     */
    public static  Node reverseList2(Node head){
        Node pre =null;
        Node next= null;
        while (head!=null){
            next = head.next;
            head.next=pre;
            pre=head;
            head= next;
        }
        return pre;
    }

    /**
     * 3.将两个有序链表进行合并
     * @param head1
     * @param head2
     * @return
     */
    public static  Node mergeTwoList3(Node head1,Node head2){
         if(head1==null&&head2==null){
             return null;
         }
         if(head1==null){
             return head2;
         }
         if(head2==null){
             return head1;
         }

         Node head= null;
         if(head1.value>head2.value){
             head=head2;
             head.next=mergeTwoList3(head1,head.next);
         }else {
             head=head1;
             head.next=mergeTwoList3(head1.next,head2);
         }
         return head;
    }


    public static Node init(){
        Node node1=new Node(1);
        Node node2=new Node(8);
        Node node3=new Node(3);
        Node node4=new Node(6);
        Node node5=new Node(5);
        Node node6=new Node(4);
        Node node7=new Node(7);
        Node node8=new Node(2);
        Node node9=new Node(9);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node9;

        return node1;
    }


    /**
     * 一个链表，奇数位升序，偶数位降序，对该链表进行排序
     * @param args
     */
    /*public static void main(String[] args) {
        Node head = init();

        Node[] list = getNode1(head);
        Node head1=list[0];
        Node head2=list[1];

        head2 = reverseList2(head2);

        head = mergeTwoList3(head1, head2);

        while (head!=null){
            System.out.print(head.value+" ");
            head =head.next;
        }
    }*/


    /*public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        node1.next=node2;
        node3.next=node4;
        Node node= mergeTwoList2(node1,node3);
        while (node!=null){
            System.out.print(node.value+" ");
            node =node.next;
        }



        *//*node1.next=node2;
        node2.next=node3;
        node3.next=null;

        traverse(node1);*//*
        //插入头结点
        *//*Node new1=new Node(0);
        headInsert(node1,new1);
        traverse(new1);*//*

        //插入尾结点
        *//*Node newTail=new Node(4);
        tailInsert(node3,newTail);
        traverse(new1);

        System.out.println(find(new1,2));*//*

        *//*Node node5 =new Node(5);
        insert(node1,node5);
        traverse(new1);*//*

        *//*delete(new1,node2);
        traverse(new1);*//*
        *//*System.out.println(getMid(node1).value);*//*

        *//*Node node =reverseList(node1);
        while (node!=null){
            System.out.println(node.value+" ");
            node =node.next;
        }*//*
    }*/


    /**
     * 归并排序
     * 归并排序是利用归并的思想实现的排序方法，该算法采用经典的分治策略（分治法将问题分成一些小的问题
     * 然后归并求解，而治的阶段则将分的阶段得到的各答案‘修补’在一起，即分而治之）。
     * 可以看到这种结构很想一颗完全二叉树，本题的归并排序我们采用递归去实现（也可采用迭代的方式去实现）。
     * 分阶段可以理解为就是递归拆分子序列的过程，递归的深度为log下角标2n
     */

    /**
     * 归并排序应该算是链表排序最佳的选择了，保证了最好和最坏时间复杂度都是nlogn,而且它在数组排序中广受诟病的空间
     * 复杂度在链表排序中也从O(n)降到了O(1).
     * 归并排序的一般步骤为：
     * 1.将待排序数组（链表）取中点并一分为二；
     * 2.递归地对左半部分进行归并排序
     * 3.递归地对右半部分进行归并排序
     * 4.将两个半部分进行合并，得到结果。
     * 首先用快慢指针（快慢指针思路，快指针一次走两步，慢指针一次走一步，快指针在链表末尾时，慢指针恰好在链表的中点）
     * 的方法找到链表中间节点，然后递归的对两个子链表排序，把两个排好序的子链表合并成一条有序的链表。
     */


    /**
     * 148题
     * @param head
     * @return
     */

    public static  Node sortList(Node head){
        if(head==null|| head.next==null){
            return head;
        }
        Node mid=getMid2(head);
        Node right = mid.next;
        mid.next=null;//咬断
        Node node =mege(sortList(head),sortList(right));
        return node;
    }

    /**
     * 取中点
     *
     */
    public static Node getMid2(Node head){
        if(head==null){
            return  head;
        }
        Node fast= head;
        Node slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }






    /**
     * 4.将两个半部分进行合并，得到结果
     * @return
     */
   public static Node mege(Node head1,Node head2){
        if(head1==null|| head2==null){
            return head1 !=null? head1:head2;
        }

        Node head= head1.value<head2.value?head1:head2;//基链
        //声明两个指针
        Node cur1=head== head1 ?head1:head2;
        Node cur2=head==head1 ?head2:head1;
        //head的上下
        Node pre = null;//cur1的上一个结点
        Node next= null;//cur2的下一个结点

        while (cur1!=null&&cur2!=null){
           if(cur1.value<=cur2.value){
               pre =cur1;
               cur1=cur1.next;
           }else {
               next=cur2.next;
               pre.next=cur2;
               cur2.next=cur1;
               pre = cur2;
               cur2=next;
           }
        }
       pre.next=cur1==null?cur2:cur1;
       return head;
    }


    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(8);
        Node node3=new Node(3);
        Node node4=new Node(6);
        Node node5=new Node(5);
        Node node6=new Node(4);
        Node node7=new Node(7);
        Node node8=new Node(2);
        Node node9=new Node(9);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node9;
        Node node = sortList(node1);
        while (node!=null){
            System.out.print(node.value+" ");
            node =node.next;
        }
    }

}
