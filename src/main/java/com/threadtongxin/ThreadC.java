package com.threadtongxin;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/711:29
 */
public class ThreadC extends Thread{

    private Object lock;

    public ThreadC(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (MyList2.size() !=5){
                System.out.println("wait begin " + System.currentTimeMillis());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end  " + System.currentTimeMillis());
            }
        }
    }
}
