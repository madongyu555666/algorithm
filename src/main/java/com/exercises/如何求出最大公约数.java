package com.exercises;


/**
 *
 */
public class 如何求出最大公约数 {


    /**
     * 辗转相除法，又叫做欧几里得算法
     * 两个正整数a和b（a》b）,他们的最大公约数等于a除以b的余数c，b和c之间的最大公约数
     * 当两个整数较大时，取摸运算性能比较差
     */

    public static int getGreatest(int a,int b){
        int big=a>b?a:b;
        int small=a<b?a:b;
        if(big%small==0){
            return small;
        }
        return getGreatest(big%small,small);
    }




    /**
     * 更相减损术：两个正整数a和b（a》b），他们的最大公约数等于a-b的差值c，和较小数b的最大公约数
     * 运算次数大于辗转相除法
     */
    public static int getGreatest2(int a,int b){
        if(a==b){
            return a;
        }
        int big=a>b?a:b;
        int small=a<b?a:b;
        return getGreatest2(big-small,small);
    }

    /**
     * 移位运算的性能非常好，更相减损术+移位运算 O(log(min(a,b)))
     */
    public static int gcd(int a,int b){
        if(a==b){
            return a;
        }
        //让整数与1进行与运算，等于0是偶数，不等于0是奇数
        if((a&1)==0&&(b&1)==0){
            //1.当a和b都为偶数时，gcd（a,b）=2*gcd(a/2,b/2)=2*gcd(a>>1,b>>1)
            return gcd(a>>1,b>>1)<<1;
            //<<1就是乘以2
        }else if((a&1)==0&&(b&1)!=0){
            //2.当a为偶数时，b为奇数时，gcd（a,b）=gcd(a/2,b)=gcd(a>>1,b)
            return gcd(a>>1,b);
        }else if ((a&1)!=0&&(b&1)==0){
            //3.当a为奇数时，b为偶数时，gcd（a,b）=gcd(a,b/2)=gcd(a,b>>1)
            return gcd(a,b>>1);
        }else {
            //4.当a,b为奇数时，先利用更相减损术运算一次，gcd（a,b）=gcd(b,a-b),此时a-b必然是偶数，然后继续进行移位运算。
            int big=a>b?a:b;
            int small=a<b?a:b;
            return gcd(big-small,small);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(25,5));
        System.out.println(gcd(100,80));
        System.out.println(gcd(27,14));
    }

}
