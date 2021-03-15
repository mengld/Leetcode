import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;

        List<ListNode> list = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            if (list.contains(p))
                return true;
            list.add(p);
            p = p.next;
        }
        return false;
    }
}
