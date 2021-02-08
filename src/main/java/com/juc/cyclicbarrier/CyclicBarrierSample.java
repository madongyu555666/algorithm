package com.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: //一种辅助性的同步结构，允许多个线程等待到达某个屏障。
 * @date 2021/2/514:45
 */
public class CyclicBarrierSample {


    public static void main(String[] args) {
        CyclicBarrier barrier=new  CyclicBarrier(5,new Runnable() {
            @Override
            public void run() {
                System.out.println("Action...GO again!");
            }
        });

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CyclicWorker(barrier));
            t.start();
        }
    }


    static class CyclicWorker implements Runnable {
        private CyclicBarrier barrier;
        public CyclicWorker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Executed");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
