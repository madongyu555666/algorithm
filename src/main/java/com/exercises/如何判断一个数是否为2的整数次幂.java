package com.exercises;

public class 如何判断一个数是否为2的整数次幂 {

    /**
     * 0与1按位与运算的结果是0,所以凡是2的整数次幂和它本身减1的结果进行与运算，结果都是必定是0，如果一个整数不是2的整数次幂，结果一定不是0
     */
    public static boolean isPowerOf2(int num){
        return (num&num-1)==0;
    }
}
