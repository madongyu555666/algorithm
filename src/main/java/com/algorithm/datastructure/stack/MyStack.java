package com.algorithm.datastructure.stack;


import com.algorithm.datastructure.linkedlist.singlelinkedlist.Node;

/**
 * 基本操作
 * 栈的两种实现：
 * 1.静态栈（数组）
 * 2.动态栈（链表）
 *
 * 进栈
 * 出栈
 * 遍历
 * 清空
 * 判断是否为空
 *
 */

/**
 * 使用链表创建的栈
 */
public class MyStack {

    public Node statckTop;
    public Node statckBottom;

    public MyStack(Node statckTop, Node statckBottom) {
        this.statckTop = statckTop;
        this.statckBottom = statckBottom;
    }

    /**
     * 进栈
     */
    public static  void pushStack(MyStack myStack,int value){
       Node node =new Node(value);
       node.next=myStack.statckTop;
       myStack.statckTop=node;
    }

    /**
     * 遍历
     * 栈顶元素指针不指向栈底
     */
    public static void traverse(MyStack myStack){
        Node stackTop=myStack.statckTop;
        while (stackTop!=myStack.statckBottom){
            System.out.println(stackTop.value + "");
            stackTop=stackTop.next;
        }
        System.out.println();
    }

    /**
     * 判断栈是否为空
     */
    public static boolean isEmpty(MyStack myStack){
        if(myStack.statckTop==myStack.statckBottom){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 出栈
     */
    public static void popStack(MyStack myStack){
       //栈不为空才出栈
        if(!isEmpty(myStack)){
            Node statckTop = myStack.statckTop;
            myStack.statckTop= statckTop.next;
            System.out.println(statckTop.value);
        }
    }

    /**
     * 清空栈
     */
    public static  void claerStack(MyStack myStack){
        myStack.statckTop=null;
        myStack.statckBottom=myStack.statckTop;
    }


    public static void main(String[] args) {
        MyStack myStack=new MyStack(new Node(0),new Node(0));
        myStack.statckBottom = myStack.statckTop;

        System.out.println(isEmpty(myStack));

        pushStack(myStack,1);
        pushStack(myStack,2);
        pushStack(myStack,3);
        traverse(myStack);
        System.out.println(isEmpty(myStack));

        popStack(myStack);

        claerStack(myStack);

        System.out.println(isEmpty(myStack));

    }




}
