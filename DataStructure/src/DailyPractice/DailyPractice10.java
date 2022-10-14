package DailyPractice;

import org.junit.Test;

public class DailyPractice10 {

     private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head.next.next, slow = head;

        while(fast!=null&&fast.next != null){
            fast= fast.next.next;
            slow= slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    @Test
    public void testDeleteMiddle(){
         ListNode head = new ListNode(1);
         head.next=new ListNode(2);
         head.next.next=new ListNode(3);
         head.next.next.next=new ListNode(4);
         deleteMiddle(head);
    }

    public int maxArea(int[] height) {
        int left =0,right = height.length-1,gap=height.length-1;
        int max=0;
        while(left<right){
            max = Math.max(max,Math.min(height[left],height[right])*gap);
            gap--;
            int i = height[left] > height[right] ? right-- : left++;
        }
        return max;
    }

    /**
     * 8. String to Integer (atoi)
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        char[] ss = s.toCharArray();
        boolean positive = true;
        for(char si:ss){
            while(si==' ') continue;
            positive = si =='-'? false:true;
            continue;
            
        }
    }
}
