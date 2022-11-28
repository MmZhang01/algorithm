package DailyPractice;

import javafx.util.Pair;

import java.util.*;

public class DailyPractice30 {

    /**
     * 223. Rectangle Area
     *
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 分别找横轴相交的长度和纵轴相交的长度
        // ax1,ax2,bx1,bx2 排序，中间两个值的
        // 如果bx1>=ax2  或者  ax1>=bx2 无相交
        // y坐标同理
        if (bx1 >= ax2 || ax1 >= bx2 || by1 >= ay2 || ay1 >= by2) {
            return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        }
        int[] arr1 = new int[]{ax1, ax2, bx1, bx2};
        int[] arr2 = new int[]{ay1, ay2, by1, by2};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - (arr1[2] - arr1[1]) * (arr2[2] - arr2[1]);
    }


    /**
     * 263. Ugly Number
     * @param n
     * @return
     */

    // ugly number 即质因数只有2/3/5
    public boolean isUgly(int n) {
        // 如果一个数大于5，且不能被2/3/5 整除则不是一个ugly number
        if(n<=0) return false;
        while (n>5){
            if(n%2==0){
                n=n/2;
            } else if (n%3==0) {
                n=n/3;
            } else if (n%5==0) {
                n=n/5;
            }else return false;
        }
        return true;
    }

    /**
     * 5. Longest Palindromic Substring
     * @param s
     * @return
     */
    // 找最长的palindrome substring
    //brute force O(n^3)
    // dp O(n^2)
    public String longestPalindrome(String s) {

        // dp 二维数值  用来存储 s 从i到j substring 是否为palindrome
        int n = s.length();
        String res = null;
        int palindromeStart = 0,maxL = 0;
        boolean[][] dp = new boolean[n][n];

        for(int i = n-1;i>=0;i--){ // i是substr 的初始位置    倒序 使得之前判断完成的可以得到利用
            for(int j =i;j<n;j++){ // j是substr 的尾部
                dp[i][j] = (s.charAt(i)==s.charAt(j)&& (j-i<3 || dp[i+1][j-1]) ); // 保证j-i>=3
                if(dp[i][j]&&j-i+1>maxL){
                    palindromeStart = i;
                    maxL = j-i+1;
                }
            }
        }
        return s.substring(palindromeStart,palindromeStart+maxL);
    }
// 另一种方法，  对于每个字符做初始值，向两侧扩散 找palindrome
    // 两种情况， 当前字符是中间值，当前字符不是中间值
//    public String longestPalindrome(String s) {
//        if(s == null || s.length() < 1) return null;
//
//        int start = 0;
//        int end = 0;
//
//        for(int i = 0; i < s.length(); i++) {
//            int len1 = expandFromMiddle(s, i, i);
//            int len2 = expandFromMiddle(s, i, i+1);
//            int len = Math.max(len1, len2);
//
//            if(len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//
//        return s.substring(start, end + 1);
//    }
//    public int expandFromMiddle(String s, int left, int right) {
//        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            left--;
//            right++;
//        }
//        return right - left - 1;
//    }

    /**
     * 14. Longest Common Prefix
     * @param strs
     * @return
     */

    // prefix   string
    // indexOf
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0]; // 取一个字符串 当作初始的prefix
        for(int i =1;i<strs.length;i++){ // 对剩余的string[] 遍历
            while(strs[i].indexOf(prefix)!=0){ // 该prefix在 当前字符串的位置   等于0意味该prefix即为当前字符串的prefix
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }


    /**
     * 148. Sort List
     * @param head
     * @return
     */

//    public ListNode sortList(ListNode head) {
//
//        // method 1 merge sort up2down     time O(nlogn)   space O(logn)调用n个栈
//        if(head==null||head.next==null) return head;
//        ListNode mid = getMid(head);
//        ListNode left = sortList(head);
//        ListNode right = sortList(mid);
//        return merge(left,right);
//    }
//
//    private ListNode merge(ListNode left,ListNode right){ // 合并两个有序链表
//        if(left==null) return right;
//        if(right==null) return left;
//        if(left.val<right.val){
//            left.next=merge(left.next,right);
//            return left;
//        }else {
//            right.next = merge(left,right.next);
//            return right;
//        }
//    }
//    private ListNode getMid(ListNode head){    // 对半截取链表
//        if(head==null||head.next==null) return head;
//        ListNode slow = head,fast = head.next.next;
//        while(fast!= null && fast.next!=null){
//            slow = slow.next;
//            fast=fast.next.next;
//        }
//        ListNode tmp = slow.next;
//        slow.next=null;
//        return tmp;
//    }

    // method 2 : using heap
        public ListNode sortList(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            Queue<Integer> queue = new PriorityQueue();
            ListNode tmp = head;
            while(tmp!=null){
                queue.add(tmp.val);
                tmp=tmp.next;
            }
            ListNode tmp2 = head;
            while(tmp2!=null){
                tmp2.val= queue.poll();
                tmp2=tmp2.next;
            }
            return head;
    }




}