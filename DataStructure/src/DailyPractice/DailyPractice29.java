package DailyPractice;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DailyPractice29 {
    // search

    /**
     * 947. Most Stones Removed with Same Row or Column
     * @param stones
     * @return
     */

    // dfs
    // 使用集合标记坐标是否已抵达
    // 发现尚未抵达的坐标，对其进行遍历  把与其横坐标或纵坐标相等的坐标进行 递归标记
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int numOfIslands = 0;
        for(int[] s1:stones){
            if(!visited.contains(s1)){
                dfs1(s1,visited,stones);
                numOfIslands++;
            }
        }
        return stones.length-numOfIslands;

    }
    private void dfs1(int[] s1, Set<int[]> visited, int[][] stones){
        visited.add(s1);
        for(int[] s2:stones){
            if(!visited.contains(s2)){
                if( s1[0]==s2[0]||s1[1]==s2[1]){
                    dfs1(s2,visited,stones);
                }

            }
        }
    }



    public int countNodes(TreeNode root) {
        if(root ==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    /**
     * 374. Guess Number Higher or Lower
     * @param n
     * @return
     */
    // binary search
    public int guessNumber(int n) {
        long l=0,r= (long)n+1;
        while(l+1!=r){
            long m = l+(r-l)/2;
            if(guess((int)m)<0){
                r=m;
            }else l=m;
        }
        return (int)l;
    }

    private int guess(int n){
        int pick=3;
        if(n>pick) return -1;
        else if (n<pick) {
            return 1;
        }
        else return 0;
    }

    @Test
    public void testGuessNumber(){
        System.out.println(guessNumber(2147483647));
    }


    /**
     * 3. Longest Substring Without Repeating Characters
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for(char c:s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                queue.add(c);
                max = Math.max(max,queue.size());
            }else{
                while(queue.peek()!=null &&queue.peek()!=c){
                    set.remove(queue.poll());
                }
                queue.poll();
                queue.add(c);
            }
        }
        return max;

//  使用hashmap， 在值直面存下该字符位置。
        //   所以这里使用两个指针，指针i用来遍历字符串，指针j为substr的初始位置
        //      每次出现重复值时，改变指针j的位置，即max（当前j，重复值下标+1）
//        if (s.length()==0) return 0;
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int max=0;
//        for (int i=0, j=0; i<s.length(); ++i){
//            if (map.containsKey(s.charAt(i))){
//                j = Math.max(j,map.get(s.charAt(i))+1);
//            }
//            map.put(s.charAt(i),i);
//            max = Math.max(max,i-j+1);
//        }
//        return max;
    }

    /**
     * 4. Median of Two Sorted Arrays
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 二分法，分别找到位于中间位置的数
        // 加入一共有八个数，找到位置分别排在第四位和第五位的数。
        // 辅助函数 二分查找，查找一个数列中，一个数字所在的位置。返回值为该数字的位置
        //红蓝条件 注意， 把小于等于查找值数量的数 放在蓝方。
        //我们想要一个准确位于m/2 的值， 如果没有任何值正好位于m/2（由于相等的数，我们取0），则说明最后一个在蓝方的数字的范围已经包含了m/2

        int m = nums1.length+nums2.length;
        int l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        while(l+1!=r){
            int middle = (l+r)/2;
            if(bs(nums1,middle)+bs(nums2,middle)<=m/2){
                l=middle;
            }else r=middle; // l is the result at m/2
        }
        if(m%2==0){
            int l1 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE;
            while(l1+1!=r1){
                int middle1 = (l1+r1)/2;
                if(bs(nums1,middle1)+bs(nums2,middle1)<=m/2-1){
                    l1=middle1;
                }else r1=middle1; // l1 is the result at m/2-1
            }
            return ((double) l+(double) l1)/2;
        }else return (double) l;
    }

    private int bs(int[] nums,int num){
        int l=-1, r = nums.length;
        while(l+1!=r){
            int m = (l+r)/2;
            if(nums[m]<num){
                l=m;
            }else r=m;
        }
        return r; // 该数字在数列中所处的下标。
    }

    @Test
    public void test(){
        int[] arr1= new int[]{1,2};
        int[] arr2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
}
