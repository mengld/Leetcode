class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode p, q, temp;
        p = head;
        temp = head.next;
        head.next = null;

        while (temp != null) {
            q = temp;
            temp = q.next;
            q.next = p;
            p = q;
        }

        return p;
    }
}
