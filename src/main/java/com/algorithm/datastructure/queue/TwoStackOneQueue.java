package com.algorithm.datastructure.queue;

/**
 * 实战：两个栈实现一个对列
 */

import java.util.Stack;

/**
 * 必须实现两点：
 * 1.如果stackPush要往stackPo中压数据。必须一次性把stackPush中的数据全部压入。
 * 2.如果stackPop不为空，stackPush绝对不能向stackPop中压入数据。
 * （保证数据得到顺序）
 */
public class TwoStackOneQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackOneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void add(int value){
        stackPush.push(value);
    }


    /**
     * stackPush 出
     * stackPop 入
     * 最后stackPop在出，就变成队列
     * @return
     */
    public int poll(){
        if(stackPush.isEmpty()&&stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();

    }


    /**
     * 获取队首
     * @return
     */
    public int peek(){
        if(stackPush.isEmpty()&&stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.isEmpty()) {
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackOneQueue queue=new TwoStackOneQueue(new Stack<Integer>(),new Stack<Integer>());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        //取队首
        System.out.println(queue.peek());
        //出栈
        System.out.println(queue.poll());

    }


}
