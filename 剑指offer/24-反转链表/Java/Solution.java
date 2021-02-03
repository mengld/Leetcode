class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}

class Solution {
    // 定义语义：将以head为头节点的链表逆置,接受头节点，返回尾节点
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode nextNode = head.next;
        head.next = null;
        ListNode node = reverseList(nextNode);
        nextNode.next = head;

        return node;
    }
}
