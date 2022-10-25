package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice15 {

    /**
     * 76. Minimum Window Substring
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int m =s.length(),n=t.length();
        if(m<n) return "";
        if(n==1){
            if(s.contains(t)) return t;
        }

        //iterate substr from length n to m
        for(int i=n;i<=m;i++){
            // i represent the length of substr
            for(int j=0;j<=m-i;j++){
                String tmp = s.substring(j,j+i);
                if(sub(tmp,t)) return tmp;
        }
            }
        return "";
        }
    private boolean sub(String Bll,String Sll){
        LinkedList<Character> list=new LinkedList<>();
        for(char b:Bll.toCharArray()){
            list.add(b);
        }
        for(int i=0;i<Sll.length();i++){
            if(!list.removeFirstOccurrence(Sll.charAt(i))){
                return false;
            }
        }
        return true;

        }
    @Test
    public void testMinWindow(){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    /**
     * 64. Minimum Path Sum
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m =grid.length,n=grid[0].length;
        int[] dp= new int[n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[j]=dp[j];
                } else if (i==0) {
                    dp[j]=dp[j-1];
                }else {
                    dp[j] = Math.min(dp[j],dp[j-1]);
                }
                dp[j]+=grid[i][j];
            }
        }
        return dp[n-1];
    }

    /**
     * 62. Unique Paths
     */
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]=dp[j]+dp[j-1];
            }
        }
        return dp[n-1];
    }

















}
