package AllTypes.Stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> dataStack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val){
        dataStack.push(val);
        min = Math.min(min,val);
        minStack.push(min);
    }

    public void pop(){
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty()?Integer.MAX_VALUE:minStack.peek();
    }

    public int top(){
        return dataStack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
