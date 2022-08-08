package LinkedList;

/*
链表
1。 快慢指针
2。 dummy node 头部不确定的情况
3。 指针head
 */

import LinkedList.MyLinkedList.ListNode;
import org.junit.Test;

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
    @Test
    public void test2(){
        ListNode input=new ListNode(1);
        input.next=new ListNode(2);
        input.next.next=new ListNode(3);
        input.next.next.next=new ListNode(4);
        input.next.next.next.next=new ListNode(5);
        MyLinkedList.reverseList1(input);

    }

    @Test
    public void test3(){
        ListNode input = new ListNode(1);
        input.next=new ListNode(2);
        input.next.next=new ListNode(2);
        input.next.next.next=new ListNode(2);
        input.next.next.next.next=new ListNode(4);
        ListNode meng = MyLinkedList.deleteDuplicates(input);
        while(meng!=null){
            System.out.println(meng.val);
            meng=meng.next;
        }
    }

    @Test
    public void test4(){
        ListNode input = new ListNode(1);
        input.next=new ListNode(2);
        input.next.next=new ListNode(3);
        input.next.next.next=new ListNode(4);
        input.next.next.next.next=new ListNode(5);
        ListNode meng = MyLinkedList.removeNthFromEnd(input,5);
        while(meng!=null){
            System.out.println(meng.val);
            meng=meng.next;
        }
    }

    @Test
    public void test5(){
        ListNode input = new ListNode(1);
        input.next=new ListNode(2);
        input.next.next=new ListNode(3);
        input.next.next.next=new ListNode(4);
//        input.next.next.next.next=new ListNode(5);
        ListNode meng = MyLinkedList.swapPairs(input);
        while(meng!=null){
            System.out.println(meng.val);
            meng=meng.next;
        }
    }

    @Test
    public void test6(){
        ListNode input1 = new ListNode(1);
        input1.next=new ListNode(2);
        input1.next.next = new ListNode(3);
        ListNode input2 = new ListNode(1);
        input2.next=new ListNode(2);
        input2.next.next = new ListNode(3);
        input2.next.next.next = new ListNode(0);
        MyLinkedList meng = new MyLinkedList();
        ListNode output = meng.addTwoNumbers(input1,input2);
        while(output!=null){
            System.out.println(output.val);
            output=output.next;
        }

    }

    @Test
    public void test7(){
        ListNode input2 = new ListNode(1);
        input2.next=new ListNode(2);
        input2.next.next = new ListNode(2);
        input2.next.next.next = new ListNode(1);
        MyLinkedList meng = new MyLinkedList();
        System.out.println( meng.isPalindrome(input2));
    }


    public static void main(String[] args){
        test1();
    }
}
