// https://leetcode-cn.com/problems/remove-linked-list-elements/submissions/
// mengld
// 2020-8-3
// 递归

class Solution4 {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        ListNode res = removeElements(head.next, val);
        if (head.val == val)
            return res;
        else {
            head.next = res;
            return head;
        }
    }
}
