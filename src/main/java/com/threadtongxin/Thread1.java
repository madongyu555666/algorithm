package com.threadtongxin;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/711:13
 */
public class Thread1 extends Thread {

    private MyObject objectA;


    public Thread1(MyObject objectA) {
        this.objectA = objectA;
    }

    @Override
    public void run() {
        super.run();
        objectA.methodA();
    }
}
