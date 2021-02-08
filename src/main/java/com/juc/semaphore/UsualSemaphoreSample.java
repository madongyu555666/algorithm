package com.juc.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: java信号量
 * @date 2021/2/514:01
 */
public class UsualSemaphoreSample {

    public static void main(String[] args) {
        System.out.println("start");
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(new SemaphoreWorker(semaphore));
            thread.start();
        }
    }


    static class SemaphoreWorker implements Runnable {
        private String name;
        private Semaphore semaphore;
        public SemaphoreWorker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                log("a permit!");
                semaphore.acquire();
                log("acquire a permit!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                log("release a permit!");
                semaphore.release();
            }

        }

        private void log(String msg){
            if(name==null){
               name=Thread.currentThread().getName();
            }
            System.out.println(name+" "+msg);
        }
    }



}
