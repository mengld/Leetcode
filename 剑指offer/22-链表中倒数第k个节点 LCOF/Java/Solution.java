// https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
// 2020-11-10
// mengld

// 双指针法

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p = head, q = head;
        while (k-- > 0) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }

        return q;
    }
}
