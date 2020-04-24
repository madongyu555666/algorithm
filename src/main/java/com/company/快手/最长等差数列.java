package com.company.快手;
import java.util.*;

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

   public int longestArithSeqLength(int[] A) {
        int length=A.length;
        //构建HashMap: key: 数的值， value: 由数在 数组A中的下标 所构成的ArrayList
        Map<Integer, List<Integer>> map=new HashMap<>(length);
        //遍历数组A并构造HashMap
        for (int i = 0; i < A.length; ++i) {
            map.computeIfAbsent(A[i],unused ->new ArrayList<> ()).add(i);
        }
       //存储最终的结果
       int res=0;
       //计数器，初始化为2(从2起步)
       int count=2;
       //确定等差数列中的第1个数
       for (int i=0;i<length-res;++i){
           //确定等差数列中的第2个数
           for (int j=i+1;j<length-res+1;++j){
               //计算等差数列的 差值
               int diff=A[j]-A[i];
               //若差值为0，则A[j]和A[i]相等，在HashMap中查找key为A[i]或A[j] 的value(ArrayList的长度，即下标的个数)
               if(diff==0){
                   //更新res的值
                   res = Math.max(res,map.get(A[i]).size());
                   continue;
               }
               //获取 当前等差数列中， 理论上的 下1个数的值
               int next=A[j]+diff;
               //记录 等差数列中，最后1个数的下标(初始化为j，即等差数列中第2个数的下标)
               int last_idx=j;
               //HashMap中 存在 当前等差数列， 下1个数的理论值
               while (map.containsKey(next)){
                   //获取key为理论值的 value(ArrayList)
                   List<Integer> integers = map.get(next);
                   //Collections内置函数二分查找
                   last_idx = -(Collections.binarySearch(integers, last_idx) + 1);
                   if(last_idx==integers.size()){
                       break;
                   }
                   last_idx=integers.get(last_idx);
                   //count + 1
                   ++count;
                   //计算 当前等差数列中， 理论上的 下1个数的值
                   next += diff;
               }
               //更新res的值
               res = Math.max(res, count);
               //count计数 重置为2(从2起步)
               count = 2;
           }
       }
       return res;
    }


}
