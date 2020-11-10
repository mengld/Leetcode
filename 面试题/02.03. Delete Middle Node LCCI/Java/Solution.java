// https://leetcode-cn.com/problems/delete-middle-node-lcci/
// 2020-11-10
// Author: 赠瑰留香
// 思路：把下一个结点的数据域赋值给这个已知结点，然后删掉下一个结点

class Solution {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
