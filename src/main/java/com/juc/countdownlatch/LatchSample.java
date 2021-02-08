package com.juc.countdownlatch;
import	java.util.concurrent.CountDownLatch;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: //允许一个或多个线程等待某些操作完成。
 * @date 2021/2/514:28
 */
public class LatchSample {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new FirstBatchWorker(latch));
            thread.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SecondBatchWorker(latch));
            thread.start();
        }

        // 注意这里也是演示目的的逻辑，并不是推荐的协调方式
        while ( latch.getCount() != 1 ){
            Thread.sleep(100L);
        }

        System.out.println("Wait for first batch finish");
        latch.countDown();

    }


    static class FirstBatchWorker implements Runnable {
        private CountDownLatch latch;

        public FirstBatchWorker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("First batch executed!");
            latch.countDown();
        }
    }

    static class SecondBatchWorker implements Runnable {
        private CountDownLatch latch;

        public SecondBatchWorker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
                System.out.println("Second batch executed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
