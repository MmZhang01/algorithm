package DynamicProgramming;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
动态规划，在矩阵中的应用
矩阵路径 只能向右或向下移动
除了在第一行或者第一列  每一步 都来源于上一步向右或向下。
两类题目
一，计算最小路径   最小上一路的总值+当前值
二，计算路径数目  第一行的路径数都是一，第一列的路径数也都是一  其余路径数等于其左侧一步总数+上侧一步总数
 */

public class MatrixPath {
    /**
     * 64. Minimum Path Sum (Medium)
     */
    public int minPathSum(int[][] grid) {
        if(grid.length==0||grid[0].length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int[] dp= new int[n];
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    dp[j]=dp[j-1];
                }else if(j==0){
                    dp[j]=dp[j];
                }else{
                    dp[j]=Math.min(dp[j],dp[j-1]);
                }
                dp[j]+=grid[i][j];
            }
        }
        return dp[n-1];
    }

    /**
     * 62. Unique Paths (Medium)
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
    /*
    math method    C(m+n-2,m-1)
    public int uniquePaths(int m, int n) {
    int S = m + n - 2;  // 总共的移动次数
    int D = m - 1;      // 向下的移动次数
    long ret = 1;
    for (int i = 1; i <= D; i++) {
        ret = ret * (S - D + i) / i;
    }
    return (int) ret;
}
     */


}
