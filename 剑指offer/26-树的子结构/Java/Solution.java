class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
}
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null)
            return false;

        return Judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean Judge(TreeNode node1, TreeNode node2)  {

        if (node2 == null)
            return true;
        if (node1 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return Judge(node1.left, node2.left) && Judge(node1.right, node2.right);
    }
}
