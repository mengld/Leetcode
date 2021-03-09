class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode p = head;
        ListNode q = head.next;
        ListNode temp = null;
        head.next = null;

        while (q != null) {
            temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }

        return p;
    }
}
