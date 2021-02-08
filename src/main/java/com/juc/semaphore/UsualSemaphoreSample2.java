package com.juc.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: java信号量
 * @date 2021/2/514:01
 */
public class UsualSemaphoreSample2 {

    public static void main(String[] args) throws InterruptedException{

        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(new SemaphoreWorker(semaphore));
            thread.start();
        }
        System.out.println("start");
        semaphore.release(5);
        System.out.println("Wait for permits off");
        while (semaphore.availablePermits()!=0) {
            Thread.sleep(100L);
        }
        System.out.println("Action...GO again!");
        semaphore.release(5);
    }


    static class SemaphoreWorker implements Runnable {
        private Semaphore semaphore;
        public SemaphoreWorker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Executed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }



}
