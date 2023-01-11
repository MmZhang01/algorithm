package AllTypes.Sort;


import java.util.List;

// merge sort
// time O(nlogn) space O(1)
// up2down
// 1. getmid split the linked list into two
// 2. sort
// 3. merge two ordered linkedlist
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode mid = getMid(head);
        ListNode left =  sortList(head);
        ListNode right = sortList(mid);
        merge(left,right);
        return head;
    }

    private ListNode getMid(ListNode head){
        if(head == null|| head.next == null) return head;
        ListNode slow = head,fast = head.next.next;
        while(fast!=null||fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        return tmp;


    }

    private ListNode merge(ListNode head1,ListNode head2){
        if(head1 == null) return head2;
        if(head2 == null )return head1;
        if(head1.val<head2.val){
            head1.next=merge(head1.next,head2);
            return head1;
        }else{
            head2.next = merge(head1,head2.next);
            return head2;
        }
    }



}
