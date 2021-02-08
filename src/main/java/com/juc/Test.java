package com.juc;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 使用多线程累加
 * @date 2020/12/139:47
 */
public class Test implements Runnable{
    volatile int s=0;


    public static void main(String[] args) {

        Test test=new Test();
        for(int i= 0;i<1000;i++){
            Thread t=new Thread(test);
            t.start();
        }
    }

    @Override
    public void run() {
        s++;
        System.out.println(s);
    }




}
