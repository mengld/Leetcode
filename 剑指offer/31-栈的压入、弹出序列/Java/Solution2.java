import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            int in = pushed[i];
            int out = popped[j];
            if (in == out) {
                j ++;
                while (!stack.isEmpty() && stack.peek() == popped[j]){
                    stack.pop();
                    j ++;
                }
                i ++;
            } else {
                stack.push(in);
                i ++;
            }
        }
        while (j < popped.length) {
            if (stack.pop() != popped[j]) {
                return false;
            }
            j ++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {2, 1, 0};
        int[] popped = {1, 2, 0};
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed, popped));
    }
}
