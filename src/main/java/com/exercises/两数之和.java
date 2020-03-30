package com.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2020/3/2416:00
 */
public class 两数之和 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 时间复杂度n*n,空间复杂度1
     * @param array
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] array,int target){
        int[] result=new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]+array[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return  result;
                }
            }
        }
        return result;
    }


    public static int[] twoSum2(int[] array,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);//key是值，value是索引
        }
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];//得到值
            if(map.containsKey(complement)&&map.get(complement) != i){
                return new int[] { i, map.get(complement) };
            }
        }
        return null;

    }

    public static void main(String[] args) {
        int[] array=new int[]{2, 7, 11, 15};
        int[] sum = twoSum2(array, 9);
        System.out.println(Arrays.toString(sum));

    }
}
