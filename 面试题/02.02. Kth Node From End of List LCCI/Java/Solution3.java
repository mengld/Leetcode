// https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
// 2020-11-10
// mengld

// 借助栈，全部压栈，依次弹栈，直到第k个元素

class Solution {
    public int kthToLast(ListNode head, int k) {

        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            ListNode q = p;
            p = p.next;
            stack.push(q.val);
        }

        for (int i = 0; i < k - 1; i++) {
            stack.pop();
        }
        
        return stack.pop();
    }
}
