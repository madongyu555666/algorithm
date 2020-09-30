package com.company.快手;

import java.util.Arrays;
import java.util.Random;


/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2020/8/1017:38
 */
public class 数组中的第K个最大元素_215 {

    /*
    * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    *
    *
    *例子：输入: [3,2,1,5,6,4] 和 k = 2
          输出: 5
    *
    * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
      输出: 4
      ,5
    * */


    /*Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }*/

    /**
     * @description: 使用java函数暴力求解
     * @param
     * @return
     * @author madongyu
     * @date 2020/8/17 10:03
     */
    /*public int findKthLargest(int[] nums, int k) {
        int length=nums.length;
        Arrays.sort(nums);
        return nums[length - k];
    }*/


    /**
     * @param
     * @return
     * @description: 使用快速排序
     * @author madongyu
     * @date 2020/8/17 10:06
     */
    public static int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        // 转换一下，第 k 大元素的索引是 len - k
        int tag = length - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == tag) {
                return nums[index];
            } else if (index < tag) {
                left = index + 1;
            } else {
                right = length - 1;
            }
        }
    }

    /**
     * @param
     * @return
     * @description: 找出切分元素
     * @author madongyu
     * @date 2020/8/17 10:10
     */
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = j + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                //i比j大
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        return j;
    }

    /**
     * @param
     * @return
     * @description: 交换元素
     * @author madongyu
     * @date 2020/8/17 10:13
     */
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

    }

    private static Random random = new Random(System.currentTimeMillis());
    /**
     * @param
     * @return
     * @description: 避免递归树加深，随机选择切分点
     * @author madongyu
     * @date 2020/8/17 10:23
     */
    public static int findKthLargest3(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        // 转换一下，第 k 大元素的索引是 len - k
        int tag = length - k;

        while (true) {
            int index = partition2(nums, left, right);
            if (index == tag) {
                return nums[index];
            } else if (index < tag) {
                left = index + 1;
            } else {
                right = length - 1;
            }
        }
    }

    /**
     * @param
     * @return
     * @description: 找出切分元素
     * @author madongyu
     * @date 2020/8/17 10:10
     */
    private static int partition2(int[] nums, int left, int right) {
        // 在区间 [left, right] 这个区间执行 partition 操作
        if(left<right){
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums,left,randomIndex);
        }
        int pivot = nums[left];
        int j = left;
        for (int i = j + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                //i比j大
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        return j;
    }


    public static void main(String[] args) {
        /*int kthLargest = new 数组中的第K个最大元素_215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);*/
        int nums[] = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = findKthLargest3(nums, 4);
        System.out.println(kthLargest);
    }




}
