package LinkedList;


import TwoPointers.ListNode;

import java.util.LinkedList;


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
        ListNode(int x){
            val=x;
            next=null;
        }
    }

    /**
     *160. Intersection of Two Linked Lists (Easy)
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1= headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
