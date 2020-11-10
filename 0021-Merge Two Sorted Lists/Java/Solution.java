// https://leetcode-cn.com/problems/merge-two-sorted-lists/
// 2020-11-10
// mengld

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummyHead.next = l1;
                l1 = l1.next;
            }

            else {
                dummyHead.next = l2;
                l2 = l2.next;
            }

            dummyHead = dummyHead.next;
        }

        if (l1 != null)
            dummyHead.next = l1;
        else
            dummyHead.next = l2;

        return head.next;
    }
}
