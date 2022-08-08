package DynamicProgramming;

/*
动态规划
创建动态数据dp[]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 343. Integer Break (Medim)
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int[] dp=new int[n];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            for(int j=1;j<i/2;j++){
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }

    /**
     * 279. Perfect Squares(Medium)
     */
    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }

    /**
     * 91. Decode Ways (Medium)
     */
    public static int numDecodings(String s) {
        if(s==null||s.charAt(0)=='0'){return 0;}
        int n=s.length();
        if(n==1){return 1;}
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i]+dp[i-1];
            }
            int twoDigits= Integer.parseInt(s.substring(i-2,i));
            if(twoDigits>9 && twoDigits<27){
                dp[i]=dp[i]+dp[i-2];
            }
        }
        return dp[n];
    }
}
