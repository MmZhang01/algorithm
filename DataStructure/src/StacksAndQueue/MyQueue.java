package StacksAndQueue;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks (Easy)
 */

    /*
    1.使用两个栈实现队列
    2.一个栈进行输入，并将其输出的值输入到第二个栈中。这样实现了输入顺序的反转。
    3.数值顺序反转后，调用第二个栈的方法效果等同与队列
     */
public class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    private void in2out(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }

    public void push(int x){
        in.push(x);
    }

    public int pop(){
        in2out();
        return out.pop();
    }

    public int peek(){
        in2out();
        return out.peek();
    }
    public boolean empty(){
        return in.isEmpty() && out.isEmpty();
    }

}
