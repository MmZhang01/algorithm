package LinkedList;



import LinkedList.MyLinkedList.ListNode;

public class MyLinkedListTest {

//    private static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
    public static void test1(){

        ListNode c = new ListNode(8);
        c.next=new ListNode(4);
        c.next.next=new ListNode(5);

        ListNode input1 = new ListNode(4);
        input1.next=new ListNode(1);
        input1.next.next=c;


        ListNode input2 =new ListNode(5);
        input2.next = new ListNode(6);
        input2.next.next = new ListNode(1);
        input2.next.next.next = c;



        ListNode meng = MyLinkedList.getIntersectionNode(input1,input2);
        while (meng!=null){
            System.out.println(meng.val);
            meng=meng.next;
        }
    }


    public static void main(String[] args){
        test1();
    }
}
