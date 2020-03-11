package com.algorithm.datastructure.tree;


import java.util.Arrays;

/**
 * 优先队列是二叉堆实现的
 */
public class PriorityQueue {
    private int[] array;
    private int size;

    public PriorityQueue() {
        array=new int[32];
    }

    /**
     * 入队
     */
    public void enQueue(int key){
        //队列超出范围，扩容
        if(size>=array.length){
           resize();
        }
        array[size++]=key;
        upAdjust();
    }


    /**
     * 出队
     */
    public int deQueue() throws Exception {
        if(size<0){
            throw new Exception("the queue is empty!");
        }
        //获取堆顶元素
        int head=array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * 扩容
     */
    private void resize() {
        int newSize=this.size*2;
        this.array= Arrays.copyOf(this.array,newSize);
    }

    /**
     * 二叉堆上浮
     */
    public void  upAdjust(){
        //取最后一个数
        int childIndex =size-1;
        //依靠数组下标
        //因为假设父节点下标识parent，那么它的左孩子下标就是2*parent+1，右孩子下标就是2*parent+2
        int parentIndex = (childIndex-1)/2;
        //temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex>0&&temp<array[parentIndex]){
            array[childIndex] =array[parentIndex];
            childIndex=parentIndex;
            parentIndex=(parentIndex-1)/2;
        }
        array[childIndex]=temp;
    }


    /**
     *下沉
     */
    public  void downAdjust(){
        //temp保存父节点值，用于最后的赋值
        /*int temp = array[parentIndex];
        int childIndex=2*parentIndex+1;*/
        int parentIndex=0;
        int temp = array[parentIndex];
        int  childIndex=1;
        while (childIndex <size){
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if(childIndex+1<size && array[childIndex+1]<array[childIndex]){
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

    public static void main(String[] args)  {
        PriorityQueue priorityQueue=new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        try {
            System.out.println("出队元素："+priorityQueue.deQueue());
            System.out.println("出队元素："+priorityQueue.deQueue());
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
