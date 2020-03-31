package com.exercises;


import java.util.Stack;

/**
 * 实现一个栈，改栈带有出栈，入栈，取最小元素3个方法
 */
public class 最小栈的实现 {

    //主要栈
    private Stack<Integer> mainStack=new Stack<>();
    //最小栈
    private Stack<Integer> minStack=new Stack<>();

    public void push(int element){
        mainStack.push(element);
        //如果最小栈为空，或者新元素小于或者等于最小栈栈顶，则将新元素
        if(minStack.empty()||element<=minStack.peek()){
              minStack.push(element);
        }
    }

    public Integer pop(){
        //如果出栈元素和最小栈栈顶元素值相等，最小栈出栈
        if(mainStack.peek().equals(minStack.peek())){
                minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin()throws Exception{
        if(mainStack.empty()){
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }


    public static void main(String[] args) throws Exception{
        最小栈的实现 stack=new 最小栈的实现();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());


    }
}
