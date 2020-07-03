package com.jikeshijian.tanchao;

/**
 * @author madongyu
 * @title: x的平方根
 * @projectName algorithm
 * @description: 69
 * @date 2020/6/1122:03
 */
public class x的平方根 {

    /*public int mySqrt(int x) {
       long left = 0;
       long right = x/2+1;
       while (left<right){
           long mid=(left+right+1)>>>1;
           long square=mid*mid;
           if(square>x){
               right=mid-1;
           }else {
               left=mid;
           }
       }
       return (int)left;
    }*/

    /*public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }*/

    public int mySqrt(int x) {
        if(x==0||x==1){
            return x;
        }
        int l=1;
        int r=x;
        int res = 0;
        while (l<=r){
            int m=(l+r)/2;
            if(m==x/m){
                return m;
            }else if(m>x/m){
                r=m-1;
            }else {
                l=m+1;
                res=m;
            }
        }
        return res;
    }
}
