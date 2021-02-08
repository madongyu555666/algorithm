package com.company.阿里;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 62的变种
 * @date 2020/10/199:09
 */
public class 求最短路径 {
    /*
 问题：// #评测题目: 给定一个m*n的地图，从(0, 0)走到(m-1, n-1)，只能向右或向下移动，求所有可能的路径数
// # 例：
// #  o是可走点，x是不可走点，大小为5*4
// #   o o o o o
// #   o x o x o
// #   o o o o x
// #   o o o o o
*/

    //动态规划
    //时间复杂度O(nm),空间复杂度：O（m）,利用滚动数组优化
    public static int answer(int[][] test) {
        //宽
        int m = test.length;
        //长
        int n = test[0].length;
        int[] g = new int[n + 1];
        g[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (test[i][j - 1] == 1) {
                    //不能通过
                    g[j] = 0;
                } else {
                    //能通过j-1是上边界，也就是例如：（0,1），（1,0）=2
                    g[j] += g[j - 1];
                }
            }
        }
        return g[n];
    }



    public static void main(String[] args) {
        int[][] c = {{0, 2, 3, 4,5,6}, {6, 1, 8,1,10,6}, {11, 12, 13, 14,1,6},{16,17,18,19,20,6},{16,17,18,19,20,6}};
        int[][] a = {{0, 2, 3, 4,5}, {6, 1, 8,1,10}, {11, 12, 13, 14,1},{16,17,18,19,20}};
        int[][] b = {{0, 2, 3, 4}, {6, 1, 8,1}, {11, 12, 13, 14}};
        int answer = answer(a);
        System.out.println(answer);

    }
}
