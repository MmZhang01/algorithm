package DailyPractice;

import java.util.*;

public class DailyPractice16 {
    // todayTopic : dp
    /**
     * 645. Set Mismatch
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> map =new HashMap<>();
        int dup=0,missing=0;
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int i=1;i<=nums.length;i++){
            if(map.containsKey(i)){
                if(map.get(i)==2) dup=i;
            }else{
                missing=i;
            }
        }
        return new int[]{dup,missing};
    }

    private class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length+1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right+1]-sum[left];
        }
    }


    /**
     * 413. Arithmetic Slices
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        //int array dp used to store the number of arithmetic that ends with the number nums[n]
        // as dp[n] = dp[n-1]+1

        int[] dp = new int[nums.length];
        int sum=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
            }
        }

        // sum the dp to get the total number of arithmetic
        for(int d:dp){
            sum+=d;
        }
        return sum;
    }

    /**
     * 343. Integer Break
     * @param n
     * @return
     */
    // 数字拆分  找最大乘积
    // alternative dp1 dp2 dp3 is fixed, after this only need to consider dp[i]*dp[n-i]
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i/2;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }

    /**
     * 91. Decode Ways
     * @param s
     * @return
     */
    public int numDecodings(String s) {
//        int n=s.length();
//        int[] dp=new int[n+1];
//        dp[n]=1;
//        for(int i=n-1;i>=0;i--)
//            if(s.charAt(i)!='0') {
//                dp[i]=dp[i+1];
//                if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
//                    dp[i]+=dp[i+2];
//            }
//        return dp[0];


        // dp[n] means forward n number's combination dp[n]=dp[n-1]+dp[n-2]
        //but we have to make sure s.char at position n-1 do not equal 0 and two digit number between 10 and 26
        int n=s.length();
        int[] dp =new int[n+1];
        dp[0]=1;
        dp[1] = s.charAt(0)=='0'? 0:1;
        for(int i=2;i<=n;i++){
            int one = s.charAt(i-1)-'0';
            int two = (s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
            if(one !=0){
                dp[i]+=dp[i-1];
            }
            if(two<=26&&two>=10){
                dp[i]+=dp[i-2];
            }

        }
        return dp[n];

    }

    /**
     * 204. Count Primes
     * @param n
     * @return
     */
    // is i is a prime, then from j= i*i  j+=i is not a prime.
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int cnt=0;
        for(int i=2;i<n;i++){
            if(notPrime[i]==true){
                continue;
            }
            cnt++;
            for(long j=(long) i*i;j<n;j+=i){
                notPrime[(int)j]=true;
            }
        }
        return cnt;


    }













}
