package com.threadtongxin;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/711:13
 */
public class Thread2 extends Thread {

    private MyObject objectB;

    public Thread2(MyObject objectA) {
        this.objectB = objectA;
    }

    @Override
    public void run() {
        super.run();
        objectB.methodB();
    }

}
