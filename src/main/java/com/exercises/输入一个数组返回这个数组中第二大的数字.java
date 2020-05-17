package com.exercises;

/**
 * @author madongyu
 * @title: 输入一个数组返回这个数组中第二大的数字
 * @projectName algorithm
 * @description: TODO
 * @date 2020/4/1714:34
 */
public class 输入一个数组返回这个数组中第二大的数字 {
    //请写一个功能性的函数，输入一个数组，返回这个数组中第二大的数字。
    //要求：只能用一个for循环实现，不能做排序。
    //例如：输入的数组内容是 [3, -1, 2, 8, 4, 1] 返回 4
    public static void find (int a[],int length){
        int max=0;
        int second=0;
        for (int i=0;i<length;i++){
            if(a[i]>max){
                second=max;
                max=a[i];
            }else if(a[i]>second){
               second=a[i];
            }
        }
        System.out.println(second);
    }


    public static void main(String[] args) {
        int a[] = {3, -1, 2, 8, 4, 1};
        int length=a.length;
        find(a,length);

    }
}
