package com.jikeshijian.tanchao;

/**
 * @author madongyu
 * @title: Test2
 * @projectName algorithm
 * @description: TODO
 * @date 2021/1/1120:26
 */
public class Test2 {

    private volatile static int  i=0;

    //编程题 0到100000000 多线程累加
    public static void main(String[] args) {
         for (int i=0;i<=10;i++){
             new Thread(new Test3()).start();
         }
    }


    public static class Test3 implements  Runnable{
        public void Test3(int i){
        }
        @Override
        public void run() {
            i++;
            System.out.println(i);
        }
    }
}
