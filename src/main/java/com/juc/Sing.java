package com.juc;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 单例
 * @date 2020/12/2218:36
 */
public class Sing {

    private static Sing  sing=new Sing();

    private Sing(){}
    public static Sing get(){
        return sing;
    }

}
