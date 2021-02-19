package com.single;

/**
 * @author madongyu
 * @title: Singleton1
 * @projectName algorithm
 * @description: 单例
 * @date 2021/2/1219:21
 */
public class Singleton1 {

    private static  Singleton1 singleton1=new Singleton1();

    private Singleton1(){

    }

    public  static Singleton1 getSingleton1(){
        return  singleton1;
    }




}
