// https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
// 2020-11-10
// 作者：sdwwld


 //全局变量，记录递归往回走的时候访问的结点数量
    int size;

    public int kthToLast(ListNode head, int k) {
        //边界条件判断
        if (head == null)
            return 0;
        int val = kthToLast(head.next, k);
        ++size;
        //从后面数结点数小于k，返回空
        if (size < k) {
            return 0;
        } else if (size == k) {
            //从后面数访问结点等于k，直接返回传递的结点k即可
            return head.val;
        } else {
            //从后面数访问的结点大于k，说明我们已经找到了，
            //直接返回node即可
            return val;
        }
    }
