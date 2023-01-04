package DailyPractice;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DailyPractice36 {


    /**
     * 1339. Maximum Product of Splitted Binary Tree
     * @param root
     * @return
     */

    // dfs 求所有子叶的和 total
    // 当再次遍历dfs， 用sub 和 total-sub 求乘积
    long ret=0,total=0;
    public int maxProduct(TreeNode root) {
        total =dfs1(root);
        dfs1(root);
        return (int)(ret % (int)(1e9 + 7));

    }
    private long dfs1(TreeNode root){
        if(root==null) return 0;

        long l = dfs1(root.left);
        long r = dfs1(root.right);
        long sub = l+r+root.val;
        ret =Math.max(ret,(total-sub)*sub) ;
        return sub;
    }

    @Test
    public void testMaxProduct(){
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.left=new TreeNode(3);
        tree.right.right=new TreeNode(4);
        tree.right.right.left=new TreeNode(5);
        tree.right.right.right=new TreeNode(6);
        maxProduct(tree);
    }


    /**
     *931. Minimum Falling Path Sum
     * @param matrix
     * @return
     */

    // dp
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n==1){
            return matrix[0][0];
        }
        int[] dp = new int[n];
        int[] dp2 ;
        dp2=Arrays.copyOf(matrix[0],n);
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[j]=Math.min(matrix[i][j]+dp2[j],matrix[i][j]+dp2[j+1]);
                }else if(j==n-1){
                    dp[j]=Math.min(matrix[i][j]+dp2[j],matrix[i][j]+dp2[j-1]);
                }else{
                    dp[j]=Math.min(matrix[i][j]+dp2[j],Math.min(matrix[i][j]+dp2[j+1],matrix[i][j]+dp2[j-1]));
                }
            }
            dp2 = Arrays.copyOf(dp,n);
        }
        Arrays.sort(dp);
        return dp[0];
    }


    /**
     * 1143. Longest Common Subsequence
     * @param text1
     * @param text2
     * @return
     */

    // dp
    public int longestCommonSubsequence(String text1, String text2) {
        // two dimension dp record at position i,j the longest common subsequence
        // loop m*n time
        int m = text1.length(),n=text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1] = 1+dp[i][j];
                }else dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[m][n];
    }

    /**
     * 150. Evaluate Reverse Polish Notation
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack= new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("+","-","*","/"));
        for(String s:tokens){
            if(set.contains(s)){
                if(s.equals("+")){
                    int tmp = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp));
                } else if (s.equals("-")) {
                    int tmp1 = Integer.parseInt(stack.pop());
                            int tmp2 =  Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp2-tmp1));
                } else if (s.equals("*")) {
                    int tmp = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp));
                } else if (s.equals("/")) {
                    int tmp1 = Integer.parseInt(stack.pop()) ;
                    int tmp2 = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp2/tmp1));
                }
            }else stack.add(s);

        }
        return Integer.parseInt(stack.pop());
    }


    /**
     * 739. Daily Temperatures
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int [] ret = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); // record the index
        for(int i =0;i<temperatures.length;i++){
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int idx = stack.pop();
                ret[idx] = i-idx;
            }
            stack.add(i);
        }
        return ret;
    }
}
