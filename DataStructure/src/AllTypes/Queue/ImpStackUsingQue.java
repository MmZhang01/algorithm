package AllTypes.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImpStackUsingQue {

    /**
     * 225. Implement Stack using Queues
     */
    class MyStack {
        // to make the data fist in last out by using queue
        // each time we add an element to the queue
        // make sure the element put on the first position of the queue
        // then the data will be last in first out
        // so each time we add an element, take out the front element and add them in again
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList();
        }

        public void push(int x) {
            queue.add(x);
            int cnt = queue.size();
            while(cnt-->1){
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
