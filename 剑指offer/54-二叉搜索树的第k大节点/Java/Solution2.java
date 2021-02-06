import java.util.PriorityQueue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public int kthLargest(TreeNode root, int k) {

        inOrder(root);
        int res = 0;
        while (k-- > 0) {
            res = maxHeap.poll();
        }
        return res;
    }

    private void inOrder(TreeNode node) {

        if (node == null)
            return;

        inOrder(node.left);
        maxHeap.add(node.val);
        inOrder(node.right);
    }

}

