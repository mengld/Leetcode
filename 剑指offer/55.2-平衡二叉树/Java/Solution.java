class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {

        getTreeDepth(root);

        return isBalanced;
    }

    private int getTreeDepth(TreeNode root)  {
        if (root == null || !isBalanced)
            return 0;
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
}
