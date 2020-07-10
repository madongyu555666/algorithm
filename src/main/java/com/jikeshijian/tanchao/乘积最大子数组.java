package com.jikeshijian.tanchao;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 152
 * @date 2020/7/618:35
 */
public class 乘积最大子数组 {

    /*给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。*/
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int imax=1;
        int imin=1;
        for (int i = 0; i < nums.length; i++) {
            //由于存在负数，那么会导致最大的变最小的，最小的变最大的。
            if(nums[i]<0){
                int tmp=imax;
                imax=imin;
                imin=tmp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            max = Math.max(max,imax);
            
        }
        return max;
    }
}
