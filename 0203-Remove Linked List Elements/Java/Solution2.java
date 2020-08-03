// https://leetcode-cn.com/problems/remove-linked-list-elements/submissions/
// mengld
// 2020-8-3
// 对solution1.java进行了简化，没有进行"垃圾"处理，在运行结束后直接销毁

class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return head;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return head;
    }
}
