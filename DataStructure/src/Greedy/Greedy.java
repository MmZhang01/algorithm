package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 保证每次的结果都是局部最优
 * making the locally optimal choice at each stage
 * 1排序  2优先满足排序靠前的
 * 局部最有 --》 全局最优
 */

public class Greedy {

    /**
     * 455. Assign Cookies (Easy)
     */
    public static int findContentChildren(int[] grid, int[] size){
        if (grid == null || size == null) { return 0;}
        Arrays.sort(grid);
        Arrays.sort(size);
        int gri=0,siz=0;
        while(gri<grid.length && siz<size.length){
            if(grid[gri]<= size[siz]){
                gri++;
            }
            siz++;
        }
        return gri;
    }

    /**
     * 435. Non-overlapping Intervals (Medium)
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //每次都选择结尾最小的区间，和下一个区间比较，保证区间不重叠

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
            }
        });
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1])); // 排序，是的区间结尾最小的放在前面。与下一个区间开头进行比较，判断是否重合
        int cnt = 1; // 不重叠的个数
        int end = intervals[0][1]; // 排序后选择第一个区间，即结尾最小的值
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1]; // 如果下一个数的开头大于本次的结尾，更换结尾
            cnt++;// 不重叠个数加一。。。
        }
        return intervals.length - cnt;
    }


    /**
     * 452. Minimum Number of Arrows to Burst Balloons (Medium)
     */
    public static int findMinArrowShots(int[][] points){
        if (points.length == 0){
            return 0;}

        Arrays.sort(points,Comparator.comparingInt(o -> o[1]));
        int cnts =1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]<=end){
                continue;
            }
            end = points[i][1];
            cnts++;
        }
        return points.length-cnts;
    }

    /**
     * 406. Queue Reconstruction by Height(Medium)
     */

        /*
        * personal method: sort height from low to high, position from low to high
        * then loop the array to judge the right element at each position
        * */
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        List<int[]> queue = new ArrayList<>();
        queue.add(new int[]{0,0}); //添加初始值
        int n=0;
        while(queue.size()<people.length+1){
            for (int[] p : people) {
                int m =0;   //统计queue中比当前q[0]大的数
                for (int[] i : queue) {
                    if(p[0]<=i[0]){
                        m++;
                    }
                }
                if(m==p[1]){   // 如果位置正确，添加到队列中
                    queue.add(n,p);
                    n++;
                    break;
                }
            }
        }
        queue.remove(people.length);//删除初始值
        return queue.toArray(new int[queue.size()][]);
    }
        /*
         * a better method: sort height from high to low, sort position from low to high
         * since add an element to arraylist at a specific position, the original array move to the right
         * */

//    public static int[][] reconstructQueue(int[][] people) {
//        if (people == null || people.length == 0 || people[0].length == 0) {
//            return new int[0][0];
//        }
//        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
//        List<int[]> queue = new ArrayList<>();
//        for (int[] p : people) {
//            queue.add(p[1], p);
//        }
//        return queue.toArray(new int[queue.size()][]);
//    }

    /**
     * 121. Best Time to Buy and Sell Stock (Easy)
     */
    /*
    * brute force
    * */
//    public static int maxProfit(int[] prices) {
//        int i=0;
//        int maxprofit=0;
//        while (i<prices.length-1){
//            for (int j=i+1;j<prices.length;j++){
//                int profits = prices[j]-prices[i];
//                if(profits>maxprofit){
//                    maxprofit=profits;
//                }
//            }
//            i++;
//        }
//        return maxprofit;
//    }
    /*
    * a better way: judge the whether the value is the minimum, T, change the min,else cal the profit and compare
    * */
    public static int maxProfit(int[] prices){
        int min = prices[0];
        int max = 0;
        for (int price: prices) {
            if (price < min ){
                min = price;
            }else{
                max=Math.max(max,price-min);
            }
        }return max;
    }

    /**
     * 122. Best Time to Buy and Sell Stock II (Easy)
     */
    public int maxProfit2(int[] prices) {
        if(prices==null||prices.length<=1) return 0;
        int profit = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]-prices[i]>0){
                profit +=prices[i+1]-prices[i];
            }
        }
        return profit;
    }

    /**
     *605. Can Place Flowers (Easy)
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }

    /**
     * 392. Is Subsequence (Medium)
     */
    public static boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        if(i==s.length()) return true;
        return false;
    }

    /**
     * 665. Non-decreasing Array (Easy)
     */
    public static boolean checkPossibility(int[] nums) {
        if (nums.length == 1) return true;
        int noNormal = 0, i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] > nums[j]) {
                noNormal++;
                if (i - 1 >= 0 && nums[i - 1] > nums[j]) {
                    nums[j] = nums[i];
                } else nums[i] = nums[j];}
            i++;
            j++;
            if (noNormal > 1) return false;
            }
        return true;
    }

    /**
     * 53. Maximum Subarray (Easy)
     */
    public int maxSubArray(int[] nums) {
        if(nums == null) return 0;
        int pre = nums[0];
        int max = pre;
        for(int i=1;i<nums.length;i++){
            pre = pre>0?pre+nums[i]:nums[i];
            max = Math.max(pre,max);
        }
        return max;
    }

    /**
     * 763. Partition Labels (Medium)
     */
    /*
    将第一个字母出现的最后一个位置当成第一个片段的切割位置
    然后遍历第一个片段的字母，分别搜索其最终出现的位置，决定要不要拓展切割位置

    tip 先遍历一遍，将每个字母的最后位置储存起来
     */
    public static List<Integer> partitionLabels(String s) {
        int[] lastIndexOfChar = new int[26];
        for(int i=0;i<s.length();i++){
            lastIndexOfChar[(int)s.charAt(i)-'a']=i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end =0;
        for(int i=0;i<s.length();++i){
            end = Math.max(end,lastIndexOfChar[(int)s.charAt(i)-'a']);
            if(i==end){
                partition.add(end-start+1);
                start = end+1;
            }
        }
        return partition;
    }
}































