// https://leetcode-cn.com/problems/implement-stack-using-queues/submissions/
// mengld
// 2020-2-15
// 用单队列实现。每加入一个元素，便将其之前的元素都逆序到其后

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size()-1; i ++) {
            queue.add(queue.peek());
            queue.remove();
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return (int)queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return (int)queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
