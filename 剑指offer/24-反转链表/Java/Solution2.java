class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = dummyHead.next;
            dummyHead.next = temp;
            head = head.next;
        }
        return dummyHead;
    }
}
