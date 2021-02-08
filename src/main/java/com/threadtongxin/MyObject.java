package com.threadtongxin;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO 同步是指多个线程通过synchronized关键字这种方式来实现线程间的通信。
 * @date 2021/2/711:11
 */
public class MyObject {

    synchronized public void methodA(){
        System.out.println(Thread.currentThread().getName());
    }
    synchronized public void methodB(){
        System.out.println(Thread.currentThread().getName());
    }


}



