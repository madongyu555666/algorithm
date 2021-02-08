package com.threadtongxin;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/711:29
 */
public class ThreadD extends Thread{

    private Object lock;

    public ThreadD( Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
       synchronized (lock){
           for (int i = 0; i <10 ; i++) {
               MyList2.add();
               if(MyList2.size()==5){
                   lock.notify();
                   System.out.println("已经发出了通知");
               }
               System.out.println("添加了" + (i + 1) + "个元素!");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
    }
}
