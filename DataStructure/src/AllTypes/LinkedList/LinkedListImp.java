package AllTypes.LinkedList;

public class LinkedListImp {
//   recursive / iterative
    public ListNode reverseList(ListNode head) {

//        // recursive
//        if(head == null || head.next==null) return head;
//        // reverse head next
//        ListNode tmp = head.next;
//        ListNode newhead = reverseList(tmp);
//        tmp.next = head;
//        head.next = null;
//        return newhead;

        // iterative
        ListNode newhead = new ListNode(-1);
        while(head!=null){
            ListNode tmp = head.next;
            head.next = newhead.next;
            newhead.next = head;
            head=tmp;
        }
        return newhead.next;
    }

        // fast slow pointers
    public ListNode middleNode(ListNode head) {
        if(head == null||head.next==null) return head;
        // two situation here, if we want cut the middle, we should stop between the middle
//        ListNode slow = head,fast = head.next.next;
//        while (fast!=null&&fast.next!=null){
//            slow= slow.next;
//            fast=fast.next.next;
//        }
//        return slow;
        // if we want return the middle
        ListNode slow = head,fast = head.next.next;
        while(fast!=null&&fast.next!=null){
            slow= slow.next;
            fast=fast.next.next;
        }
        return slow.next;
    }

//  character for linked list  a+c +b= b+c +a
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA,b = headB;
        while(a!=null||b!=null){
            if(a==b) return a;
            a = a==null?b:a.next;
            b = b==null?a:b.next;
        }
        return null;
    }
//  if there is a cycle the fast pointer will catch the slow pointer
    public boolean hasCycle(ListNode head) {
        if(head== null) return false;
        ListNode slow = head,fast =head;
        while(slow !=null&& fast!=null&&fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
            if(slow == fast ) return true;
        }
        return false;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode fakeHead = new ListNode(-1);
//        fakeHead.next = head;
//        ListNode prev = fakeHead;
//        ListNode curr = fakeHead.next;
//        int i = 1;
//        while (i < m) {
//            prev = curr;
//            curr = curr.next;
//            i++;
//        }
//        ListNode node = prev;
//        while (i <= n) {
//            ListNode tmp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = tmp;
//            i++;
//        }
//        node.next.next = curr;
//        node.next = prev;
//        return fakeHead.next;
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
            ListNode ret =reverseList(head);
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
        start.next=reverseList(h1);
        h1.next=end;
        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null|| head.next==null ) return head;
        ListNode odd = head,even = head.next, evenFist = head.next;
        while (odd!=null&&even !=null&&odd.next!=null&&even.next!=null){
            odd.next=odd.next.next;
            odd= odd.next;
            even.next= even.next.next;
            even=even.next;
        }
        odd.next=evenFist;
        return head;
    }

}
