class CQueue {

     private Stack<Integer> stack1 = null;
    private Stack<Integer> stack2 = null;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(value);
    }

    public int deleteHead() {
        
        if (stack1.isEmpty() && stack2.isEmpty())
            return -1;

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}
