public class Solution {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return head;
            else
                set.add(head);
            head = head.next;
        }
        return null;
    }
}
