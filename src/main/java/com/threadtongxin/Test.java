package com.threadtongxin;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/711:20
 */
public class Test {

    /*public static void main(String[] args) {
        MyObject obj = new MyObject();
        Thread1 t1 = new Thread1(obj);
        Thread2 t2 = new Thread2(obj);

        t1.start();
        t2.start();
    }*/
    /*public static void main(String[] args) {
        MyList list = new MyList();
        ThreadA t1 = new ThreadA(list);
        t1.setName("A");
        t1.start();
        ThreadB t2 = new ThreadB(list);
        t2.setName("B");
        t2.start();
    }*/
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadC a = new ThreadC(lock);
            a.start();
            Thread.sleep(50);
            ThreadD b = new ThreadD(lock);
            b.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
