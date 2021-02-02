/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {

        int n = 0;
        ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = dummyHead.next;
            dummyHead.next = temp;
            head = head.next;
            n++;
        }
        
        int[] res = new int[n];
        ListNode p = dummyHead.next;
        for (int i = 0; i < n; i ++) {
            res[i] = p.val;
            p = p.next;
        }
        return res;
    }
}
