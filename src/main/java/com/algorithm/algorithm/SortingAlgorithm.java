package com.algorithm.algorithm;


import java.util.Arrays;

/**
 * 排序算法
 */
public class SortingAlgorithm {


    /**
     * 冒泡排序，时间复杂度：logn*n
     */
    public static void sort(int[] array){
        int count=0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                int temp=0;
                count++;
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            
        }
        System.out.println(count);
    }



    /**
     * 冒泡排序优化
     */
    public static void sort2(int[] array){
        int count=0;
        for (int i = 0; i < array.length-1; i++) {
            //有序标记，每一轮的初始值都试true
            boolean isSorted=true;
            for (int j = 0; j < array.length-i-1; j++) {
                int temp=0;
                count++;
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    //因为有元素进行交换，所以不是有序的，标记为false，
                    isSorted=false;

                }
            }
            if(isSorted){
                break;
            }
        }
        System.out.println(count);
    }



    /**
     * 冒泡排序，优化
     */
    public static void sort3(int[] array){
        int count=0;
        for (int i = 0; i < array.length-1; i++) {

            //记录最后一次交换的位置
            int lastExchangeIndex=0;
            //无序数列的边界，（前一个数字比后一个大，就赋值，反之就不赋值，所以sortBorder是无序数列的边界）每次比较只需要比到这里位置
            int sortBorder =array.length-1;//数组大小
            //有序标记，每一轮的初始值都试true
            boolean isSorted=true;
            count++;
            for (int j = 0; j < sortBorder; j++) {
                int temp=0;
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    //因为有元素进行交换，所以不是有序的，标记为false，
                    isSorted=false;
                    //更新为最后一次交换元素的位置
                    lastExchangeIndex=j;

                }
            }
            sortBorder=lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
        System.out.println(count);
    }


    /**
     * 鸡尾酒排序：排序过程就像钟摆一样，第一轮从左到右，第二轮从右到左，第三轮从左到右
     * 优点：减少排序的回合数
     * 缺点：代码量增加
     * 使用场景：大部分元素已经有序的情况
     */
    public static void sort4(int[] array){
        int tmp=0;
        int count=0;
        for (int i = 0; i < array.length/2; i++) {

            //有序标记，每一轮的初始值都试true
            count++;
            boolean isSorted=true;
            for (int j = i; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    //因为有元素进行交换，所以不是有序的，标记为false，
                    isSorted=false;

                }
            }
            if(isSorted){
                break;
            }
            //在偶数轮之前，将isSorted重新标记为true
            isSorted=true;
            //偶数轮，从右到左比较和交换
            for (int j = array.length-i-1; j > i; j--) {
                if(array[j]<array[j-1]){
                    tmp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                    //因为有元素进行交换，所以不是有序的，标记为false，
                    isSorted=false;

                }
            }
            if(isSorted){
                break;
            }
        }
        System.out.println(count);
    }


    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr,int startIndex,int endIndex){
        //递归结束条件：startIndex大于或者等于endIndex时
        if(startIndex>=endIndex){
            return;
        }
        //得到基准元素位置
        int pivotIndex=partition2(arr,startIndex,endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort(arr,startIndex,pivotIndex-1);//左
        quickSort(arr,pivotIndex+1,endIndex);//右
    }

    /**
     * 分治（双边循环法）
     * @param arr 带交换的数组
     * @param startIndex 起始下标
     * @param endIndex  结束下标
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        //取第1个位置（也可以选择随机位置）的元素作为基准元素
        int pivot =arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left!=right){
            //控制right指针比较并左移
            while (left <right&&arr[right] > pivot){
                right--;
            }
            //控制left指针比较并右移
            while (left <right&&arr[left] <= pivot){
                left++;
            }
            //交换left和right指针所指向的元素
            if(left<right){
                int p =arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        //pivot和指针重合点交换
        arr[startIndex]=arr[left];
        arr[left]=pivot;
        return left;
    }


    /**
     * 分治（单边循环法）
     * @param arr 带交换的数组
     * @param startIndex 起始下标
     * @param endIndex  结束下标
     * @return
     */
    private static int partition2(int[] arr, int startIndex, int endIndex) {
        //取第1个位置（也可以选择随机位置）的元素作为基准元素
        int pivot =arr[startIndex];
        int mark = startIndex;


        for (int i = startIndex+1; i <=endIndex; i++) {
            if(arr[i]<pivot){
                //mark移动1位，并交换值
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
            
        }

        //pivot和指针重合点交换
        arr[startIndex]=arr[mark];
        arr[mark]=pivot;
        return mark;
    }


    /**
     * 堆排序（升序）
     * @param array 待调整的堆
     */
    public static  void  heapSort(int[] array){
        //1.把无序数组构建成最大堆
        for (int i = (array.length-2)/2; i >=0; i--) {
            downAdjust(array,i,array.length);
        }
        System.out.println(Arrays.toString(array));
        //2.循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for (int i = array.length-1; i >0; i--) {
            //最后1个元素和第一个元素进行交换
            int temp= array[i];
            array[i]=array[0];
            array[0]=temp;
            //下沉调整最大堆
            downAdjust(array,0,i);
        }
    }


    /**
     *下沉
     */
    public static void downAdjust(int[] array,int parentIndex,int length){
        //temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex=2*parentIndex+1;
        while (childIndex <length){
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if(childIndex+1<length && array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，则直接跳出
            if(temp<=array[childIndex]){
                break;
            }
            //无须真正交换，单项赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex=childIndex;
            childIndex=2*childIndex+1;

        }
        array[parentIndex] =temp;
    }



    public static void main(String[] args) {
        /*int[] array =new int[]{5,8,6,3,9,2,1,7};
        sort4(array);
        System.out.println(Arrays.toString(array));*/

        /*int[] arr =new int[]{4,4,6,5,3,2,8,1};
        quickSort(arr,0,args.length-1);
        System.out.println(Arrays.toString(arr));*/

        //最大堆
        int[] arr =new int[]{1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }




}
