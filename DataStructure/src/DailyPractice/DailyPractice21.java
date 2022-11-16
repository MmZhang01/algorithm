package DailyPractice;

import StacksAndQueue.MinQueue;
import org.junit.Test;

import java.util.*;

public class DailyPractice21 {
    // queue and stack

    /**
     * 232. Implement Queue using Stacks
     */
    // 使用两个栈实现队列
    // 一个栈 负责输入， 一个负责输出
    // 当输出栈为空时，在将输入栈的值取出，放到输出栈 以实现队列的效果
    class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();

        }

        public void push(int x) {
            in.push(x);

        }

        public int pop() {
            in2out();
            return out.pop();
        }

        public int peek() {
            in2out();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        private void in2out() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }
    }

    /**
     * 225. Implement Stack using Queues
     */
    //用队列实现栈
    // 为了保证后入的值先出， 每次进入一个新的值，将队列前面的值取出再重新进入
    class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            int cnt = queue.size();
            while (cnt-- > 1) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }


    /**
     * 155. Min Stack
     */
    // 需要两个栈， 一个存数据，一个存最小值
    // 取小值时，从最小值栈取
    // 取数据时，从数据栈取
    class MinStack {
        Stack<Integer> dataStack;
        Stack<Integer> minStack;
        int min;


        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;

        }

        public void push(int val) {
            dataStack.add(val);
            min = Math.min(val, min);
            minStack.add(val);
        }

        public int pop() {

            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
            return dataStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

        public boolean empty() {
            return dataStack.isEmpty();
        }
    }


    class MinQueue {
        // 对于实现最小值队列问题，可以先将队列使用栈来实现，然后就将问题转换为最小值栈
        // 用两个最小站实现最小值队列
        MinStack in;
        MinStack out;

        public MinQueue() {
            in = new MinStack();
            out = new MinStack();

        }

        public void push(int x) {
            in.push(x);

        }

        public int pop() {
            in2out();
            return out.pop();
        }

        public int peek() {
            in2out();
            return out.top();
        }

        public boolean empty() {
            return in.empty() && out.empty();

        }
        public int getMin(){
            // 最小值为 进入栈  和 输入栈 中的最小值
            in2out();
            return Math.min(out.getMin(),in.getMin());
        }

        private void in2out() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
        }
    }

    /**
     * 20. Valid Parentheses
     * @param s
     * @return
     */
    // 用栈储存关闭括号，当开括号出现时，存入对应的关闭括号
    // 当关闭括号出现时，应该对应第一个栈取出值
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            } else if (c=='[') {
                stack.push(']');
            } else if (c=='{') {
                stack.push('}');
            } else if (stack.isEmpty()||c!=stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 739. Daily Temperatures
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
//        int[] ret = new int[temperatures.length];
//        for(int i=0;i<temperatures.length;i++){
//            int cnt=0;
//            for(int j=i+1;j<temperatures.length;j++){
//                cnt++;
//                if(temperatures[j]>temperatures[i]){
//                    ret[i]=cnt;
//                    break;
//                }
//            }
//        }
//        return ret;

        // 利用栈存储数据，相当于调用一个方法
        // 这里 方法指 findIntbigThanthis 递推 如果大于返回，每层+1
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;


    }



    @Test
    public void testDailyTemperatures(){
        int[] temperatures =new int[]{73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);

    }
}
