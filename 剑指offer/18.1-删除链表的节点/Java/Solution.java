class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {

        if (head == null)
            return null;

        if (head.val == val)
            return head.next;

        ListNode p = head;
        ListNode q = p.next;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
                break;
            }
            p = q;
            q = p.next;
        }
        return head;
    }
}
