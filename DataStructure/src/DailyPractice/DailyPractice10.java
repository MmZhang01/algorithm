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
        int i =0,ans =0,sign=1;
        while(i<s.length()&& s.charAt(i)==' ') i++;
        if(i<s.length()&&s.charAt(i)=='-'){
            sign = -1;
            i++;
        } else if (i<s.length()&&s.charAt(i)=='+') {
            i++;
        }
        while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
            if(ans > Integer.MAX_VALUE/10 || ans == Integer.MAX_VALUE/10 && s.charAt(i)>'7'){
                if(sign == 1) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
            }
            ans = ans*10 + (s.charAt(i++)-'0');
        }
        return sign*ans;

    }
    @Test
    public void testMyAtoi(){
        System.out.println(myAtoi("   123"));
    }
}





















