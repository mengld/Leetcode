import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private PriorityQueue<Integer> head;

    public MinStack() {

        stack = new Stack<>();
        head = new PriorityQueue<>();
    }

    public void push(int x) {

        stack.push(x);
        head.add(x);
    }

    public void pop() {

        head.remove(stack.pop());

    }

    public int top() {

        return stack.peek();
    }

    public int min() {

        return head.peek();
    }
}
