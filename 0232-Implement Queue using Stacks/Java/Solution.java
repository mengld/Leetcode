// https://leetcode-cn.com/problems/implement-queue-using-stacks/
// 2020-11-8
// mengld
// 用双栈模拟队列

import java.util.Iterator;
import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> stackHelper;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        stackHelper = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            stackHelper.push(stack.pop());
        }

        int res = stackHelper.pop();

        for (int i = 0; i < size - 1; i++) {
            stack.push(stackHelper.pop());
        }

        return res;
    }

    /** Get the front element. */
    public int peek() {

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            stackHelper.push(stack.pop());
        }

        int res = stackHelper.peek();

        for (int i = 0; i < size; i++) {
            stack.push(stackHelper.pop());
        }

        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("bottom [");

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            res.append(iterator.next() + " ");
        }

        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        // push 1, 2, 3
        for (int i = 1; i <= 3; i++) {
            myQueue.push(i);
            System.out.println(myQueue);
        }

        System.out.println(myQueue.peek());

        for (int i = 0; i < 3; i++) {
            myQueue.pop();
            System.out.println(myQueue);
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
