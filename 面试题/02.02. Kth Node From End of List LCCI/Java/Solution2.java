// https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
// 2020-11-10
// mengld

// 双指针法：设置两个指针p、q初始均指向头节点，第一个指针p先走k步，然后两个指针同时走，直到第一个指针p走到末尾，此时返回第二个指针q的值即可

class Solution {
    public int kthToLast(ListNode head, int k) {

        ListNode p = head, q = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        
        return q.val;
    }
}
