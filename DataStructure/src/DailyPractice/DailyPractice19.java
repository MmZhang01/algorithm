package DailyPractice;

import java.util.List;
import java.util.Stack;

public class DailyPractice19 {
    // today's topic  linked list + tree

    /**
     * 19. Remove Nth Node From End of List
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针， 快指针提前走到终点位置，此时慢指针下一步调整链条

        ListNode fast = head,slow = head;
        while(n!=0){
            fast=fast.next;
            n--;
        }
        if(fast==null){
            return head.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    /**
     * 24. Swap Nodes in Pairs
     * @param head
     * @return
     */
    // 使用递归
    // 1.首先写出特殊情况的返回值
    // 2. 互换前两个节点的指向
    //      临时指针指向第二节点
    //      第一节点指向第三个值 即临时节点的下一个值
    //      第二节点指向第一节点，即临时节点指向head
    //      头指针指向第二节点，即头指针指向临时节点
    //3. 返回头指针
    public ListNode swapPairs(ListNode head) {
        if (head ==null||head.next==null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = swapPairs(tmp.next);
        tmp.next= head;
        head =tmp;
        return head;
    }

    /**
     * 445. Add Two Numbers II
     * @param l1
     * @param l2
     * @return
     */
    // 这里用栈储存链表，取出来是相当于逆序
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        //创建返回链表 储存求和的值，使用头插法 进列表
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }


    /**
     * 104. Maximum Depth of Binary Tree (Easy)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * 110. Balanced Binary Tree
     * @param root
     * @return
     */
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        compareDepth(root);
        return res;
    }

    private int compareDepth(TreeNode root) {
        if(root==null) return 0;
        int l = compareDepth(root.left);
        int r= compareDepth(root.right);
        if(Math.abs(l-r)>1) res=false;
        return Math.max(l,r)+1;
    }




}
