package DailyPractice;

import LinkedList.MyLinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Palindrome {
    /**
     * 9. Palindrome Number
     */
    public boolean isPalindrome(int x) {
        if(x<0 ||(x!=0 && x%10==0)) return false;
        int res = 0;
        while(res<x){
            res = res*10+x%10;
            x=x/10;
        }
        return x==res || x==res/10;
    }

    /**
     * 125. Valid Palindrome
     */
    public boolean isPalindrome(String s) {
        char[] check = s.toCharArray();
        for(int i =0,j=s.length()-1;i<j;){
            if(!Character.isLetterOrDigit(check[i])){
                i++;
            } else if (!Character.isLetterOrDigit(check[j])) {
                j--;
            }else if(Character.toLowerCase(check[i++])!= Character.toLowerCase(check[j--])){
                return false;
            }
        }
        return true;
    }

    /**
     * 131. Palindrome Partitioning
     */
    public List<List<String>> partition(String s) {
        return null;
    }

    /**
     * 409. Longest Palindrome
     */
    public int longestPalindrome(String s) {
        Set<Character> charset = new HashSet<>();
        for (char c : s.toCharArray()) {
            if(charset.contains(c)){
                charset.remove(c);
            }else {
                charset.add(c);
            }
        }
        if (charset.size()==0) return s.length();
        return s.length()-charset.size()+1;
    }

    /**
     * 234. Palindrome Linked List
     */
    /*
        1. put the value into an array
        2. Two Pointers
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        if (fast!= null) slow=slow.next;
        cut(head,slow);
        return isEqual(head,reverse(slow));
    }

    private void cut(ListNode head, ListNode cutNode){
        while(head.next!=cutNode){
            head=head.next;
        }
        head.next=null;
    }

    private ListNode reverse(ListNode head){
        ListNode newhead = new ListNode();
        while(head!= null){
            ListNode nextNode = head.next;
            head.next=newhead;
            newhead = head;
            head=newhead;
        }
        return newhead;
    }

    private boolean isEqual(ListNode l1,ListNode l2){
        while (l1!= null && l2!=null){
            if(l1.val!=l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

}
