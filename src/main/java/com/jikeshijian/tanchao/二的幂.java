package com.jikeshijian.tanchao;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 231
 * @date 2020/6/1818:35
 */
public class 二的幂 {
    /**
     * 要理解位运算的高低位
     * n&(n-1)=0 能证明这个数是2的幂
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
         return n>0 && (n&(n-1))==0;
    }

}
