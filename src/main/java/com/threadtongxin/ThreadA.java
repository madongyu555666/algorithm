package com.threadtongxin;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/711:29
 */
public class ThreadA extends Thread{

    private MyList myList;

    public ThreadA(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
            for (int i =0 ; i < 10; i++) {
                myList.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                    Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
