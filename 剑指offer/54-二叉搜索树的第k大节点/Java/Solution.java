import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*
中序遍历二叉搜索树，将元素依次压栈，弹出第k个元素即为第k大元素
 */
class Solution {

    private Stack<Integer> stack = new Stack<>();

    public int kthLargest(TreeNode root, int k) {

        inOrder(root);
        int res = 0;
        while (k-- > 0) {
            res = stack.pop();
        }
        return res;
    }

    private void inOrder(TreeNode node) {

        if (node == null)
            return;

        inOrder(node.left);
        stack.push(node.val);
        inOrder(node.right);
    }

}

