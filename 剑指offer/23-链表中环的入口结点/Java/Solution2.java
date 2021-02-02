class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.next == null)
            return null;

        ListNode fast = pHead, slow = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next.next;
        } while (fast != slow);

        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

/*
第一步，用两个快慢指针找环中相汇点。分别用slow, fast指向链表头部，slow每次走一步，fast每次走二步，直到fast == slow找到在环中的相汇点。
第二步，找环的入口。当fast == slow时，假设slow走过x个节点，则fast走过2x个节点。
设环中有n个节点，因为fast比slow多走一圈（n个节点），所以有等式2x = n + x，可以推出n = x，即slow实际上走了一个环的步数。
这时，我们让fast重新指向链表头部pHead，slow的位置不变，然后slow和fast一起向前每次走一步，直到fast == slow，此时两个指针相遇的节点就是环的入口。
*/
