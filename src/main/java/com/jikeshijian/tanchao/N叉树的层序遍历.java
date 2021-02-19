package com.jikeshijian.tanchao;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 62
 * @date 2020/5/199:56
 */
public class N叉树的层序遍历 {
    //给定一个m*n的地图，从(0, 0)走到(m-1, n-1)，只能向右或向下移动，求所有可能的路径数，其中o能走，x不能走
    /*
     * 到达 (m-1, n-1) 有几种方式 = 到达 (m - 1, n) 有几种方式 + 到达 (m, n-1) 有几种方式：
     * ways(m-1, n-1) = ways(m - 1, n) + ways(m, n -1)
     * */


    public static int answer(int[][] obstacleGrid) {
        //其中o=0能走，x=1不能走,
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] g = new int[n];
        if (obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 0) {
            g[0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    g[j] = 0;
                    continue;
                }
                if (j - 1 >= 0) {
                    g[j] += g[j - 1];
                }
            }
        }
        return g[n - 1];
    }


    //时间复杂度O(nm),空间复杂度：O（m）,利用滚动数组优化
    public static int answer2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i][j - 1] == 1) {
                    //不能通过
                    dp[j] = 0;
                } else {
                    //能通过j-1是上边界，也就是例如：（0,1），（1,0）=2
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        int[][] c = {{0, 2, 3, 4, 5, 6}, {6, 1, 8, 1, 10, 6}, {11, 12, 13, 14, 1, 6}, {16, 17, 18, 19, 20, 6}, {16, 17, 18, 19, 20, 6}};
        int[][] a = {{0, 2, 3, 4, 5}, {6, 1, 8, 1, 10}, {11, 12, 13, 14, 1}, {16, 17, 18, 19, 20}};
        int[][] b = {{0, 2, 3, 4}, {6, 1, 8, 1}, {11, 12, 13, 14}};
        int answer = answer2(a);
        System.out.println(answer);

    }


}
