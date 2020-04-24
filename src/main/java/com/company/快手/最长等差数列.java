package com.company.快手;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2020/4/2314:52
 */
public class 最长等差数列 {
    /**
     *给定一个整数数组 A，返回 A 中最长等差子序列的长度。
     *
     * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
     *
     */

   /* public int longestArithSeqLength(int[] A) {
        int length=A.length;
        //构建HashMap: key: 数的值， value: 由数在 数组A中的下标 所构成的ArrayList
        Map<Integer, List<Integer>> map=new HashMap<>(length);
        //遍历数组A并构造HashMap
        for (int i = 0; i < A.length; i++) {
            int i1 = A[i];

        }
    }*/

}
