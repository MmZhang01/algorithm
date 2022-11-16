package DailyPractice;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class DailyPractice27 {


    /**
     * 901. Online Stock Span
     */
    // 返回小于或等于当天股价的连续天数
    class StockSpanner {

//        Stack<Integer> stack1;
//        Stack<Integer> stack2;

        // 存一个数组，两个值，一个值是前一天价格，一个值是前一天的答案
        // 相当于一个recursive函数，这里用栈直接储存了上一个函数的值 dfs
        Stack<int[]> stack;

        public StockSpanner() {
//            stack1= new Stack<>();
//            stack2= new Stack<>();
            stack=  new Stack<>();

        }

        public int next(int price) {
            //method1 两个栈 来回导数据 O(n) O(n)
//            stack1.add(price);
//            int cnt=0;
//            while(!stack1.isEmpty()&& stack1.peek()<=price){
//                stack2.add(stack1.pop());
//                cnt++;
//            }
//            while(!stack2.isEmpty()){
//                stack1.add(stack2.pop());
//            }
//            return cnt;

            int ans = 1;
            while(!stack.isEmpty()&& stack.peek()[0]<=price){
                ans+=stack.pop()[1];
            }
            stack.add(new int[]{price,ans});
            return ans;
        }
    }

    @Test
public void test1(){
    StockSpanner ss= new StockSpanner();
    System.out.println(ss.next(100));

}

    /**
     * 1047. Remove All Adjacent Duplicates In String
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(!stack.isEmpty()&&stack.peek()==s.charAt(i)){
                stack.pop();
            }else stack.add(s.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        for(char r:stack){
            sb.append(r);
        }
        return new String(sb);
    }

    /**
     * 26. Remove Duplicates from Sorted Array
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int k=1;
        for (int i :nums){
            if(nums[k-1]!=i){
                nums[k]=i;
                k++;
            }
        }
        return k;
    }

    /**
     * 295. Find Median from Data Stream
     */
    class MedianFinder {

        // 两个PQ， 一半的数放在small，另一半放在large中
        //  small中逆序排
        // even 记录当前队列中数目是否为偶数
        // 如果是偶数 新进来的数 先进入large，然后再取出large最小值进入small 奇数则相反
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;
        private boolean even ;

        public MedianFinder() {

            small= new PriorityQueue<>(Collections.reverseOrder());
            large = new PriorityQueue<>();
            even  = true;


        }

        public void addNum(int num) {
            if(even){
                large.add(num);
                small.add(large.poll());
                even = false;
            }else {
                small.add(num);
                large.add(small.poll());
                even=true;
            }
        }

        public double findMedian() {
            if(even){
                return (large.peek()+small.peek())/2.0;
            }else return small.peek();

        }
    }





}
