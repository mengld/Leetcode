// https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
// 2020-11-10
// mengld

// 思路：遍历链表，获得遍历长度，在遍历的同时将元素顺序存储到开辟的数组中，倒数第k等价于数组中正数第len-k

class Solution {
    public int kthToLast(ListNode head, int k) {

        int len = 0;
        ListNode p = head;
        int[] nums = new int[100];
        while (p != null) {
            nums[len] = p.val;
            len ++;
            p = p.next;
        }

        int n = len - k;
        return nums[n];
    }
}
