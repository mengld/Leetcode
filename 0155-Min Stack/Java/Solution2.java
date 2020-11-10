// 思路：每次push/pop对min和minCount进行维护

import java.util.Iterator;
import java.util.Stack;


class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;
    private int minCount = 0;

    public MinStack() {

        stack = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
        if (x < min) {
            min = x;
            minCount = 1;
        }
        else if (x == min)
            minCount++;
    }

    public void pop() {

        int topElem = stack.pop();
        if (topElem == min) {
            minCount--;
            if (minCount == 0) {
                min = Integer.MAX_VALUE;
                Iterator<Integer> iterator = stack.iterator();
                while (iterator.hasNext()) {
                    int e = iterator.next();
                    if (e < min) {
                        min = e;
                        minCount = 1;
                    }

                    else if (e == min)
                        minCount++;
                }
            }
        }
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {

        return min;
    }
}
