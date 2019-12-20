package com.algorithm.simple;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 两个数之和
 * @date 2019/12/1710:02
 */
public class TwoSum {


    /**
     * @param
     * @return
     * @description: 俩个数的和
     * @author madongyu
     * @date 2019/12/17 10:02
     */
    public static int[] Sum(int[] nums,int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                  if(nums[j]==target-nums[i]){
                      return new int[] { i, j };
                  }

            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
