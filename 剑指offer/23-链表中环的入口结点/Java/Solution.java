import java.util.HashMap;
import java.util.Map;

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        Map<Integer, Integer> map = new HashMap<>();
        ListNode p = pHead;

        while (p != null) {
            if (map.get(p.val) == null) {
                map.put(p.val, 1);
                p = p.next;
            }
            else if (map.get(p.val) == 1) {
                return p;
            }
        }
        return null;
    }
}
