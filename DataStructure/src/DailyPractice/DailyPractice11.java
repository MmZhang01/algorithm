package DailyPractice;

import java.util.Arrays;
import java.util.Comparator;

public class DailyPractice11 {

    /**
     * 88. Merge Sorted Array
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        1.two pointers, undecreasing array, one point to last num in nums2, another point to position at n-1 of nums1
//        iterate nums1 reversely
        while(m-1>=0||n-1>=0){
//          both have value left
            if(m-1>=0 && n-1>=0){
                if(nums1[m-1]>nums2[n-1]){
                    nums1[m+n-1] = nums1[m-1];
                    m--;
                }else{
                    nums1[m+n-1] = nums2[n-1];
                    n--;
                }
            }
            // one run out of its values
            if(m-1<0){
                nums1[m+n-1] = nums2[n-1];
                n--;
            } else if (n-1<0) {
                nums1[m+n-1] = nums1[m-1];
                m--;
            }
        }
    }

    /**
     * 141. Linked List Cycle
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // fast slow points, if the linked list has cycle, the fast will catch the slow
        if(head==null) return false;
        ListNode slow = head,fast = head;
        while(slow!=null&&fast!=null&&fast.next!= null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow == fast) return true;
        }
        return false;

    }

    /**
     * 435. Non-overlapping Intervals
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        int cnt = 1;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int end = intervals[0][1];
        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0]>end){
                end = intervals[i][1];
                cnt++;
            }else continue;
        }
        return intervals.length-cnt;
    }
}
