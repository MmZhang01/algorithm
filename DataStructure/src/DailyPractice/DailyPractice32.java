package DailyPractice;

import java.util.*;

public class DailyPractice32 {

    //sort    partition定位/二分定位    merge   heap
    // linkedList   recursive/ 头插法/快慢指针


    /**
     *224. Basic Calculator
     * @param s
     * @return
     */
    public int calculate(String s) {
        /**
         * Start from +1 sign and scan s from left to right;
         * if c == digit: This number = Last digit * 10 + This digit;
         * if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
         * if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
         * if c == '(': Push this context sign to stack;
         * if c == ')': Pop this context and we come back to last context;
         * Add the last num. This is because we only add number after '+' / '-'.
         */
        if(s == null) return 0;

        int result = 0;
        int sign = 1;
        int num = 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(sign);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');

            } else if(c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1: -1);
                num = 0;

            } else if(c == '(') {
                stack.push(sign);

            } else if(c == ')') {
                stack.pop();
            }
        }

        result += sign * num;
        return result;
    }


    /**
     * 1235. Maximum Profit in Job Scheduling
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        // using treemap,dp
        // 按照结束时间升序排序，dp存 当前结束时间最大利润
        // 如何找到当前job开始时间时候的profit（即以当前开始时间为结束时间的profit） 二分查找/treemap（floorentry）
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i=0;i<n;i++){
            jobs[i] = new int[]{startTime[i],endTime[i],profit[i]};
        }
        Arrays.sort(jobs,(a,b)->(a[1]-b[1]));
        TreeMap<Integer,Integer> dp = new TreeMap<>();  // 第一个值为结束时间，第二个值为利润
        dp.put(0,0);
        for(int[] job:jobs){
            // 取出以当前开始时间为结束时间的最大利润
            // 如果该值不存在 取出小于该值的最大结束时间
            int cur = dp.floorEntry(job[0]).getValue()+job[2];
            if(cur>dp.lastEntry().getValue()){ // 取出上一个最大利润
                dp.put(job[1],cur);
            }
        }
        return dp.lastEntry().getValue();
    }



    // use heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        for(int num:nums){
            queue.add(num);
        }
        while(k>1){
            queue.poll();
            k--;
        }
        return queue.poll();
    }


    // linkedList

    /**
     * 206. Reverse Linked List
     * @param head
     * @return
     */

    // method 1 头插法
//    public ListNode reverseList(ListNode head) {
//        ListNode l1 = new ListNode(-1);
//        while (head!= null){
//            ListNode next = head.next;
//            head.next=l1.next;
//            l1.next=head;
//            head=next;
//        }
//        return l1.next;
//    }

    // method2 recursive
    public ListNode reverseList(ListNode head) {
        if(head== null|| head.next==null) return head;
        ListNode tmp = head.next;
        ListNode newhead = reverseList(tmp);
        tmp.next=head;
        head.next=null;
        return newhead;
    }


    /**
     * 876. Middle of the Linked List
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if(head==null) return head;
        ListNode slow = head,fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    /**
     * 160. Intersection of Two Linked Lists
     * @param headA
     * @param headB
     * @return
     */

    // a+c+b = b+c+a
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA,hb=headB;
        while(ha!=null||hb!=null){
            if(ha==hb) return ha;
            ha= ha==null?headB:ha.next;
            hb= hb==null?headA:hb.next;
        }
        return null;

    }

    /**
     * 92. Reverse Linked List II
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // left =1 单独讨论
        // 如果left=1 即反转前n个nodes
        int position=1;
        ListNode h2 = head,h1=head,start=head;
        while(position!=right){
            position++;
            h2=h2.next;
        }
        ListNode end = h2.next;
        h2.next=null;
        if(left == 1){
            ListNode ret =reverse(head);
            head.next=end;
            return ret;
        }
        position=1;
        while(position!=left){
            if(position+1==left){
                start=h1;
            }
            position++;
            h1=h1.next;
        }
        start.next=reverse(h1);
        h1.next=end;
        return head;




    }

    private ListNode reverse(ListNode head){
        ListNode newHead = new ListNode(-1);
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next=head;
            head= next;
        }
        return newHead.next;
    }

    /**
     * 328. Odd Even Linked List
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode odd = head,even = head.next,tmp=even;
        while(odd!=null&&odd.next!=null&&even!=null&&even.next!=null){
            odd.next=odd.next.next;
            odd=odd.next;
            even.next=even.next.next;
            even=even.next;
        }
        odd.next=tmp;
        return head;
    }













}
