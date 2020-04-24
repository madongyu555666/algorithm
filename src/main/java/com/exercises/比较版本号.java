package com.exercises;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;




/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *
 */
public class 比较版本号 {
    //每个字符串设置一个指针p
    public static Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        //说明在字符串结尾
        if(p>n-1){
            return new MutablePair(0,p);
        }
        int i;
        int  pEnd=p;
        while (pEnd<n&&version.charAt(pEnd)!='.'){
            ++pEnd;
        }
        //检索块
        if(pEnd !=n-1){
            i = Integer.parseInt(version.substring(p, pEnd));
        }else {
            i = Integer.parseInt(version.substring(p, n));
        }
        //查找下一个块的开头
        p = pEnd + 1;
        return new MutablePair(i,p);
    }


    public static int compareVersion(String version1, String version2) {
        int p1 = 0,p2=0;
        int n1 = version1.length(),n2 =version2.length();

        int i1,i2;
        Pair<Integer, Integer> pair;
        while (p1<n1|| p2<n2){
            pair=getNextChunk(version1,n1,p1);
            i1 = pair.getKey();
            p1 = pair.getValue();
            pair = getNextChunk(version2, n2, p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }

        }
        return 0;
    }


    public static void main(String[] args) {
        int version = compareVersion("2.1", "1.1");
        System.out.println(version);
    }




}
