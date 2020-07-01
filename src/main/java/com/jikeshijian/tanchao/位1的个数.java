package com.jikeshijian.tanchao;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 191
 * @date 2020/6/1818:27
 */
public class 位1的个数 {


    /**
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     */

    public int hammingWeight(int n) {
           int sum=0;
           while (n!=0){
               sum++;
               n &=(n-1);
           }
           return sum;
    }

}
