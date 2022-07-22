package StacksAndQueue;

import java.util.Stack;

/**
 * 155. Min Stack (Easy)
 */

/*
创建两个stack  一个储存数据，一个储存最小值
加的新值大于最小值时，添加入最小值stack的值为当前最小值（重复添加）
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
