package StacksAndQueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


/*
使用栈实现最小队列存在问题
两个栈转换时，无法保证最小值及时转换。。
 */

public class MinQueue {

    private Queue<Integer> m1=new PriorityQueue<>();


    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    private Stack<Integer> minin;
    private Stack<Integer> minout;

    private int min;

    public MinQueue(){
        minin = new Stack<>();
        minout=new Stack<>();
        min = Integer.MAX_VALUE;
    }
    private void in2out(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }

    private void minin2minout(){
        if(minout.isEmpty()){
            while(!minin.isEmpty()){
                minout.push(minin.pop());
            }
        }
    }

    public void push(int x){
        in.push(x);
        min = Math.min(min, x);
        minin.push(min);

    }

    public void pop(){
        in2out();
        minin2minout();
        minout.pop();
        out.pop();
        min =  minout.isEmpty() ? Integer.MAX_VALUE : minout.peek();
    }

    public int top(){
        in2out();
        return out.peek();
    }

    public int getMin(){
        return minout.peek();
    }

    public boolean empty(){
        return in.isEmpty() && out.isEmpty();
    }
}
