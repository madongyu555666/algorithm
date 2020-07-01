package com.jikeshijian.tanchao;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 338
 * @date 2020/6/1818:36
 */
public class 比特位计数 {

    /**
     * @param
     * @return
     * @description: 动态规划 + 最后设置位【通过】
     * @author madongyu
     * @date 2020/7/1 18:15
     */
    /*public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }*/

    /**
     * @param
     * @return
     * @description: 方法一：Pop count 【通过】
     * @author madongyu
     * @date 2020/7/1 18:31
     */
    /*public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = popcount(i);
        }
        return ans;
    }

    private int popcount(int i) {
        int count;
        for (count = 0; i != 0; count++) {
            i &= i - 1;
        }
        return count;

    }*/


}
