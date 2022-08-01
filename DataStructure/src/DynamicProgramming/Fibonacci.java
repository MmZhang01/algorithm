package DynamicProgramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fibonacci {
    /**
     *70. Climbing Stairs (Easy)
     */

    /*
    使用队列储存每一步的数据  BFS  超时！！
     */
//    public static int climbStairs(int n){
//        int[] steps = new int[]{1,2};
//        Queue<Integer> queue= new LinkedList<>();
//        queue.add(0);
//        int ret=0;
//        while (!queue.isEmpty()){
//            int size= queue.size();
//            while(size-->0){
//                int m = queue.poll();
//                for (int step : steps) {
//                    int m1=m+step;
//                    if(m1==n){
//                        ret ++;
//                    }else if(m1<n){
//                        queue.add(m1);
//                    }
//                }
//            }
//    } return ret;
//    }
    public static int climbStairs(int n){
        if(n<2){
            return n;
        }
        int pre2 = 1,pre1=2;
        for (int i = 2; i < n; i++) {
            int cur=pre1+pre2;
            pre2=pre1;
            pre1=cur;
        }
        return pre1;
    }

    /**
     * 198. House Robber (Easy)
     */

    public static int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);  // 目前最大的数额
            pre2 = pre1; // 前一个最大数额
            pre1 = cur; //当前最大数额
        }
        return pre1;
    }
}
