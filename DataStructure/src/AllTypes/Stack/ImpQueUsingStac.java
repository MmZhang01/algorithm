package AllTypes.Stack;

import java.util.Stack;

public class ImpQueUsingStac {
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
            return in.isEmpty()&&out.isEmpty();
        }

        private void in2out(){
            if(out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
        }
    }
}
