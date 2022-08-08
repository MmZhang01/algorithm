package LinkedList;


import TwoPointers.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * 链表 list node 一个空节点 包含一个值和指向下一个节点
 * 使用递归去储存数据
 * 通过对链表节点的改进-- SLL/DLL
 *
 *
 */

public class MyLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){
            val=x;
            next=null;
        }
    }

    /**
     *160. Intersection of Two Linked Lists (Easy)
     */
    /*
    两个相交的链表   相互结合，遍历，一定会相遇
    a+c+b=b+c+a
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1= headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    /**
     * 206. Reverse Linked List (Easy)
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);   //post order traversal
        next.next = head;
        head.next = null;
        return newHead;
    }
    /*
    头插法
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;  //将原链表的头部断开
            newHead.next = head;   // 断开的头部加到newHead中
            head = next;
        }
        return newHead.next;
    }

    /**
     * 21. Merge Two Sorted Lists (Easy)
     */
    /*
    recursive
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
    /*
    create dummy listNode
     */
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode head = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<= l2.val) {
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if(l1!=null){
            head.next=l1;
        }
        if(l2!=null){
            head.next=l2;
        }
        return dummy.next;
        }

    /**
     * 83. Remove Duplicates from Sorted List (Easy)
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){return head;}
        ListNode dummy = new ListNode(head.val);
        ListNode h = dummy;
        while(head!= null){
            if(h.val<head.val){
                h.next=new ListNode(head.val);
                h=h.next;
            }
            head=head.next;
        }
        return dummy;
    }

//    public static ListNode deleteDuplicates(ListNode head) {
//        if(head==null)return null;
//        ListNode p = head;
//
//        while(p.next!=null){
//            if(p.next.val==p.val){
//                p.next=p.next.next;
//            }
//            else
//                p=p.next;
//        }
//
//        return head;
//    }
    /*
    recursive
     */
//    public static ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) return head;
//        head.next = deleteDuplicates(head.next);
//        return head.val == head.next.val ? head.next : head;
//    }

    /**
     * 19. Remove Nth Node From End of List (Medium)
     */
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        int size=0;
//        ListNode pos= head;
//        while(pos!=null){
//            size+=1;
//            pos=pos.next;
//        }
//        int nee = size-n+1,ne=1;
//        pos=head;
//        if(nee == 1){return pos.next;}
//        while(ne<nee-1){
//            ne++;
//            pos=pos.next;
//        }
//        if(ne==size-1){pos.next=null; return head;}
//        pos.next=pos.next.next;
//        return head;
//    }
    /*
    快慢指针
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow = head;
        while(n-->0){
            fast=fast.next;
        }
        if(fast==null){return slow.next;}
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    /**
     * 24. Swap Nodes in Pairs (Medium)
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);  // 解决头部不确定
        node.next=head;
        ListNode pre = node;
        while(pre.next!=null&&pre.next.next!=null){
            ListNode l1 = pre.next,l2=pre.next.next;
            ListNode tmp = l2.next;
            l2.next = l1;
            l1.next = tmp;
            pre.next = l2;
            pre=l1;
        }
        return node.next;
    }

    /**
     * 445. Add Two Numbers II (Medium)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode node = new ListNode(-1);
        int carry = 0;
        while(!l1Stack.isEmpty()||!l2Stack.isEmpty()||carry != 0){
            int x = l1Stack.isEmpty()? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty()? 0 : l2Stack.pop();
            int sum = x+y+carry;
            ListNode head = new ListNode(sum%10);
            head.next = node.next;
            node.next=head;
            carry = sum/10;
        }
        return node.next;
    }
    private Stack<Integer> buildStack(ListNode l){
        Stack<Integer> stack = new Stack<>();
        while(l!=null){
            stack.push(l.val);
            l=l.next;
        }
        return stack;
    }

    /**
     * 234. Palindrome Linked List (Easy)
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        cut(head,slow);
        return isEqual(head,reverse(slow));

    }

    private ListNode reverse(ListNode head){
        ListNode node = new ListNode(-1);
        while(head!=null){
            ListNode tmp = head.next;
            head.next=node.next;
            node.next=head;
            head=tmp;
        }
        return node.next;
    }
    private void cut(ListNode head,ListNode cutNode){
        while(head.next!=cutNode){
            head=head.next;
        }
        head.next=null;
    }
    private boolean isEqual(ListNode l1,ListNode l2){
        while(l1!=null && l2!= null){
            if(l1.val!=l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }






}
