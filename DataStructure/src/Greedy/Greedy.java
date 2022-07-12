package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 保证每次的结果都是局部最优
 * making the locally optimal choice at each stage
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



}
