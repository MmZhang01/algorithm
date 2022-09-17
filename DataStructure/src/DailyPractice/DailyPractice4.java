package DailyPractice;

import org.junit.Test;

public class DailyPractice4 {
    /**
     *1770. Maximum Score from Performing Multiplication Operations
     */
    /*
    dp[][]
     */
    public int maximumScore(int[] nums, int[] multipliers) {
        int n =nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m+1][m+1];
        int score = Integer.MIN_VALUE;
        for(int i =1;i<=m;i++){
            for(int l =0;l<=i;l++){
                int pick_left = (l==0? Integer.MIN_VALUE : dp[l-1][i-l]+multipliers[i-1]*nums[l-1]);
                int pick_right = (l==i? Integer.MIN_VALUE : dp[l][i-l-1]+multipliers[i-1]*nums[n-i+l]);
                dp[l][i-l] = Math.max(pick_left,pick_right);
                if(i==m){
                    score = Math.max(score,dp[l][i-l]);
                }
            }
        }
        return score;
    }



    @Test
    public void testMaximumScore(){
        int[] nums = new int[]{-5,-3,-3,-2,7,1};
        int[] multipliers = new int[]{-10,-5,3,4,6};
        System.out.println(maximumScore(nums,multipliers));
    }
}
