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
//    public static int[][] reconstructQueue(int[][] people) {
//        if(people.length==0){return new int[0][0];
//        }
//        Arrays.sort(people,Comparator.comparingInt());
//    }
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

}































