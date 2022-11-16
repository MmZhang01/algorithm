package DailyPractice;

import org.junit.Test;

public class DailyPractice18 {
    // linked list

    /**
     * 1662. Check If Two String Arrays are Equivalent
     * @param word1
     * @param word2
     * @return
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n1=word1.length,n2= word2.length;
        String a="",b="";
        for(int i=0;i<n1||i<n2;i++){
            if(i>=n1&&i<n2){
                b+=word2[i];
                continue;
            }
            if(i>=n2&&i<n1){
                a+=word1[i];
                continue;
            }
            a+=word1[i];
            b+=word2[i];
        }
        if(a.equals(b)){
            return true;
        }
        return false;
    }


    /**
     * 160. Intersection of Two Linked Lists
     * @param headA
     * @param headB
     * @return
     */
    // a+c     b+c
    // a+c+b = b+c+a
    // so they will meet each other if intersection exists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA =headA,hB=headB;
        // if no intersection, they will both turn null at end
        while(hA!=null || hB!=null){
            if(hA==hB) return hA;
            if(hA==null) {
                hA=headB;
            }else hA=hA.next;
            if(hB==null) {
                hB= headA;
            }else hB=hB.next;
        }
        return null;
    }

    @Test
    public void testGetIntersectionNode(){
        ListNode headA = new ListNode(2);
        headA.next=new ListNode(6);
        headA.next.next=new ListNode(4);
        ListNode headB = new ListNode(1);
        headB.next=new ListNode(5);
        getIntersectionNode(headA,headB);

    }

    /**
     * 206. Reverse Linked List
     * @param head
     * @return
     */
    // 头插法 原链从左到右一一断开 参入新链的头部
    public ListNode reverseList(ListNode head) {
        ListNode l1 =new ListNode(-1);
        while(head!=null){
            ListNode next = head.next;
            l1.next=head;
            head=next;
        }
        return l1.next;
    }

    /**
     * 21. Merge Two Sorted Lists
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

    /**
     * 83. Remove Duplicates from Sorted List
     * @param head
     * @return
     */
    // 迭代前的命令 发生再迭代前，迭代后的命令，等待返回后再执行 dfs
    // 把当前方法当成一个函数去使用
    // 注意当前方法的返回值 1. 自身的特殊值 以及 dfs到底的返回值  放在最前面
    //                  2. 方法想要的返回值    一般放在后面或者条件达成
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        head.next=deleteDuplicates(head.next);
        return head.val==head.next.val ? head.next:head;
    }

}
