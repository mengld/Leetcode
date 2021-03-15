import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        if (headA == null || headB == null)
            return null;

        Set<ListNode> set = new HashSet<>();
        while (headA != null && headB != null) {
            if (set.contains(headA))
                return headA;
            else
                set.add(headA);

            if (set.contains(headB))
                return headB;
            else
                set.add(headB);

            headA = headA.next;
            headB = headB.next;
        }
        
        while (headA != null) {
            if (set.contains(headA))
                return headA;
            else
                set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB))
                return headB;
            else
                set.add(headB);
            headB = headB.next;
        }
        
        return null;
    }
}
