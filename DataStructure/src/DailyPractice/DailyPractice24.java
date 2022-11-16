package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice24 {

    /**
     * 1706. Where Will the Ball Fall
     * @param grid
     * @return
     */
    public int[] findBall(int[][] grid) {
        // 对每一列进行循环 iteration
        // 小球 通过该行之后进入下一行， 而下一列取决于 当前列以及当前cell的值 nextcolumn = currentcolumn+grid[][]
        // 如果下一列超出格子范围 或者 同一行的 当前格子与下一列的格子值相反 则小球被困
        // 否则 记录下一列的值到结果中，并把当前列改为下一列
        // 重复循环 直到 最后一行

        int res[] = new int[grid[0].length];
        for(int col = 0;col<grid[0].length;col++){
            int curCol = col;
            for(int row = 0;row< grid.length;row++){
                int nextCol = curCol+grid[row][curCol];
                if(nextCol<0 || nextCol>grid[0].length-1 || grid[row][curCol]!=grid[row][nextCol]){
                    res[col] = -1;
                    break;
                }
                res[col] = nextCol;
                curCol=nextCol;
            }
        }
        return res;
    }


    /**
     * 215. Kth Largest Element in an Array
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 要求运行时间O(n)  使用 切分
        // 切分返回值为j  以第一个参数做下标值a[j],j 即其再数组中的排序  所在arr的位置 其左侧都小于a[j] 右侧都大于a[j]
        // 使用二分查找 找到正确的位置，返回数值
        // 红蓝指针逼近 k， 蓝区 条件 返回值小于k（即不足k个小值） 红区第一个值即==k满足条件

        k = nums.length-k;
        int l= -1,r=nums.length;

        while(l+1!=r){
            int j = partition(nums,l+1,r-1);
            if(j<k){
                l=j;
            }else r=j;
        }
        return nums[r];

    }

    private int partition(int[] a, int l,int h){
        // 以下标为l的数值作为切分元素
        int i=l, j = h+1;
        while(true){
            while (i<h&&a[++i]<a[l]);
            while(j>l&&a[--j]>a[l]);
            if(i>=j){
                break;
            }
            swap(a,i,j);
        }
        swap(a,l,j);
        return j;
    }

    private void swap(int[] a,int i,int j){
        int t =a[i];
        a[i] = a[j];
        a[j]=t;
    }

    /**
     * 433. Minimum Genetic Mutation
     * @param start
     * @param end
     * @param bank
     * @return
     */

    // BFS
    public int minMutation(String start, String end, String[] bank) {
        // 标记已到达过的位置，记录步长，队列
        // 队列储存当前步长  所有可能的情况   这里集合用来标记已到达的位置
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int step = 0;
        queue.add(start);
        set.add(start);
        char[] change = new char[]{'A','C','G','T'};

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){  //对 队列中的值遍历
                String s = queue.poll();
                if(s.equals(end)) return step;
                for(char c:change){
                    for(int j=0;j<s.length();j++){
                        String next = s.substring(0,j)+c+s.substring(j+1);
                        if( !set.contains(next) && Arrays.asList(bank).contains(next)){
                            queue.add(next);
                            set.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    @Test
    public void testMinMutation(){
        System.out.println(minMutation("AACCGGTT", "AACCGGTA",new String[]{"AACCGGTA"}));
    }


}
