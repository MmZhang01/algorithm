package StacksAndQueue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues (Easy)
 */


/*
使用队列实现栈
只需要将新插入队列的数值放在第一位
每次新插入时，将原始的插入的值删除，并加到新值的后面
 */

public class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x){
        queue.add(x);
        int cnt = queue.size();
        while(cnt-- >1){
            queue.add(queue.poll());
        }
    }

    public int pop(){
        return queue.remove();
    }

    public int top(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
}
