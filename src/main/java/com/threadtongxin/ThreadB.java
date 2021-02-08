package com.threadtongxin;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/711:29
 */
public class ThreadB extends Thread{

    private MyList myList;

    public ThreadB(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
           while (true){
               if(myList.size() ==5){
                   System.out.println("==5, 线程b准备退出了");
                   throw new InterruptedException();
               }
           }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
