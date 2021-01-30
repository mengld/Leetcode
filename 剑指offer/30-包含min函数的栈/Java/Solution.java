class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
        minStack.push(minStack.isEmpty()?x:Math.min(x, minStack.peek()));
    }

    public void pop() {

        stack.pop();
        minStack.pop();
    }

    public int top() {

        return stack.peek();
    }

    public int min() {

        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
