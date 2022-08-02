package DynamicProgramming;

/*
动态规划
创建动态数据dp[]
 */
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
}
