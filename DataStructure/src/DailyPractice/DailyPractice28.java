package DailyPractice;

import org.junit.Test;

import java.util.Arrays;

public class DailyPractice28 {

    // dp

    /**
     * 300. Longest Increasing Subsequence
     * @param nums
     * @return
     */

    ///  二分查找速度更快**
    // 此处使用dp
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i =1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);
                }
            }

        }
        return max;
    }

    @Test
    public void testLengthOfLIS(){
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    /**
     * 646  Maximum Length of Pair Chain
     * @param pairs
     * @return
     */
//  此处用dp  O(n2)
    // 亦可以贪心，更好O(nlogn)

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }

    /**
     * 376. Wiggle Subsequence
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        // 当前摆动与之前摆动后的状态有关，当前摆动向上，算连续值则需要之前摆动向下+1
        // dp 使用两个dp，记录摆动的方向，如果当前摆动向上，则之前向下的值+1，如果当前摆动向下，则之前向上摆动的值+1；
        int up=1,down=1;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i]-1>0){  // 向上摆动
                up = down+1;
            }else if(nums[i]-nums[i-1]<0){ // 向下摆动
                down = up+1;
            }
        }
        return Math.max(up,down);

    }

    /**
     * 151. Reverse Words in a String
     * @param s
     * @return
     */

    //双指针  一个指针指向单词的尾部，并一个向前找到空白处，截取该单词。
    // 之后，第一个指针移动到该空白处，寻找下一个单词的尾部
    public String reverseWords(String s) {
        int p1=s.length()-1;
        String ret = "";
        while(p1>=0){
            if(s.charAt(p1)==' '){
                p1--;
                continue;
            }
            int p2=p1;
            while(p2>=0&&s.charAt(p2)!=' '){
                p2--;
            }
            ret=ret+' '+s.substring(p2+1,p1+1);
            p1=p2;
        }
        return ret.substring(1);
    }
}
