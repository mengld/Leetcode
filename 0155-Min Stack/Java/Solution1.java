// https://leetcode-cn.com/problems/min-stack/submissions/
// mengld
// 2020-2-15
// 增加辅助栈，以空间换时间

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> helper;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if(helper.isEmpty() || x < helper.peek())
            helper.add(x);
        else
            helper.add(helper.peek());
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        if (!stack.isEmpty())
            return stack.peek();
        throw new IllegalArgumentException("非法");
    }

    public int getMin() {
        if (!helper.isEmpty())
            return helper.peek();
        throw new IllegalArgumentException("非法");
    }
}
