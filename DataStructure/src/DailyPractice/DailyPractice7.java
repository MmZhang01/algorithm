package DailyPractice;

import org.junit.Test;

import java.util.PriorityQueue;

public class DailyPractice7 {
    /**
     * 557. Reverse Words in a String III
     */
    public String reverseWords(String s) {
        StringBuffer reverse = new StringBuffer();
        int n = s.length();
        for(int i=n-1;i>=0;i--){
            reverse.append(s.charAt(i));
        }

        String reversed = new String(reverse);
        String[] sp = reversed.split(" ");
        int m = sp.length;
        String[] ret = new String[m];
        for (int i = 0; i < m; i++) {
            ret[i] = sp[m-i-1];
        }
        return String.join(" ",ret);
    }

    @Test
    public void testReverseWords(){
        System.out.println(reverseWords("God Ding"));
    }


    /**
     * 2. Add Two Numbers
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode head = ret;
        int res = 0;
        while(l1!=null || l2!= null){
            if(l1!=null && l2!=null){
                head.next = new ListNode((l1.val+ l2.val+res)%10);
                res = (l1.val+ l2.val+res)/10;
                head=head.next;
                l1=l1.next;
                l2=l2.next;

            }
            else if(l1==null){
                head.next = new ListNode((l2.val+res)%10);
                res = (l2.val+res)/10;
                head=head.next;
                l2=l2.next;

            }
            else if(l2==null){
                head.next = new ListNode((l1.val+res)%10);
                res = (l1.val+res)/10;
                head=head.next;
                l1=l1.next;

            }
        }
        if(res!=0){
            head.next = new ListNode(res);
        }
        return ret.next;
    }

    @Test
    public void testAddTwoNumbers(){
        ListNode l1 =new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1,l2);

    }

    PriorityQueue
}
