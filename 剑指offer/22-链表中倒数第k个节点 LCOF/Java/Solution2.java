class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }

        // 倒数第k 等价于 正数第length-k+1
        p = head;
        int stop = length - k + 1;
        for (int i = 1; i < stop; i++) {
            p = p.next;
        }

        return p;
    }
}
