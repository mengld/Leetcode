// https://leetcode-cn.com/problems/remove-linked-list-elements/submissions/
// mengld
// 2020-8-3
// 采用了虚拟头节点dummyhead，统一了头部删除和其他部份删除的操作

class Solution3 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return dummyHead.next;
    }
}
