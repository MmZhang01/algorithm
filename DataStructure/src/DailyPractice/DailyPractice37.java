package DailyPractice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyPractice37 {


    /**
     * 841. Keys and Rooms
     * @param rooms
     * @return
     */
    int n;
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        visited = new boolean[n];
        visited[0] = true;
        dfs(rooms,rooms.get(0));
        for(boolean visit:visited){
            if (visit==false) {
                return false;
            }
        }
        return true;

    }
    private void dfs(List<List<Integer>> rooms,List<Integer> keys){
        for(int key:keys){
            if(visited[key]==true) continue;
            visited[key] = true;
            dfs(rooms,rooms.get(key));
        }
    }

    @Test
    public void testCanVisitAllRooms(){
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>(Arrays.asList(1,3));
        List<Integer> room1 = new ArrayList<>(Arrays.asList(3,0,1));
        List<Integer> room2 = new ArrayList<>(Arrays.asList(2));
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(new ArrayList<>());
        rooms.get(3).add(0);
        System.out.println(canVisitAllRooms(rooms));
    }


    /**
     * 9. Palindrome Number
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0,j = s.length()-1;
        char[] cs = s.toCharArray();
        while(i<j){
            if(cs[i]==cs[j]){
                i++;
                j--;
            }else  return false;
        }
        return true;
    }


    /**
     * 309. Best Time to Buy and Sell Stock with Cooldown
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // dp
        //  three state the day might be
        // s0  the empty cash, at this state we can rest or buy, this state from last s0 or last rest day
        // s1 with stock, at this state we can rest or sell,this state from last s0 or last s1
        // s2 rest day, this state from last s1
        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];
        s0[0]=0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for(int i = 1;i<prices.length;i++){
            s0[i] = Math.max(s0[i-1],s2[i-1]);
            s1[i] = Math.max(s0[i-1]-prices[i],s1[i-1]);
            s2[i] = s1[i-1]+prices[i];
        }
        return Math.max(s0[prices.length-1],s2[prices.length-1]);
    }


    /**
     * 34. Find First and Last Position of Element in Sorted Array
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        // find the left position
        int l = -1, r = nums.length;
        while(l+1!= r){
            int m = (r+l)/2;
            if(nums[m]<target){
                l=m;
            }else r=m; // r is the left position
        }
        // find the right position
        int l1 = -1, r1 = nums.length;
        while (l1+1!=r1){
            int m = (l1+r1)/2;
            if(nums[m]<=target){
                l1 = m;
            }else r1=m; // l1 is the right position
        }
        if(r== nums.length || nums[r]!= target){
            return new int[]{-1,-1};
        }
        return new int[]{r,l1};
    }


    /**
     * 33. Search in Rotated Sorted Array
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // find position of  the smallest value
          // as the ratation values are all smaller than the left values
        int l= -1, r = nums.length;
        while(l+1!= r){
            int m = (l+r)/2;
            if(nums[m]>nums[nums.length-1]){
                l=m;
            }else r=m;   // r is the position of the smallest value
        }
        // binary search for target
        int l1,r1;
        if(target<=nums[nums.length-1]){
            l1 = r-1 ;
            r1 = nums.length;
            while (l1+1!=r1){
                int m =(l1+r1)/2;
                if(nums[m]<target){
                    l1=m;
                }else r1=m;    // r1 is the result
            }
        } else {
            l1 = -1 ;
            r1 = r;
            while (l1+1!=r1){
                int m =(l1+r1)/2;
                if(nums[m]<target){
                    l1=m;
                }else r1=m;    // r1 is the result
            }
        }
        if(r1==nums.length||nums[r1]!=target) return -1;
        else return r1;
    }

    @Test
    public void testSearch(){
       System.out.println(search(new int[]{1,3},3));
    }


    /**
     * 790. Domino and Tromino Tiling
     * @param n
     * @return
     */
    public int numTilings(int n) {
        long[] dp = new long[n + 3];
        dp[0] = 1; dp[1] = 2; dp[2] = 5;
        for (int i = 3; i < n; i ++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
        return (int)dp[n - 1];
    }


}
