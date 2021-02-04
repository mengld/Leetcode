import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {

    // inorder的索引映射表
    private Map<Integer, Integer> mapIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0)
            return null;
        if (preorder.length == 1) {
            TreeNode root = new TreeNode(preorder[0]);
            root.left = null;
            root.right = null;
            return root;
        }

        for (int i = 0; i < inorder.length; i++) {
            mapIndex.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd)
            return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {
            return root;
        } else {
            int index = mapIndex.get(rootVal);
            int leftNodes = index - inStart;
            int rightNodes = inEnd - index;
            root.left = buildTree(preorder, preStart + 1, preStart + leftNodes, inorder, inStart, index - 1);
            root.right = buildTree(preorder, preEnd - rightNodes + 1, preEnd, inorder, index + 1, inEnd);
            return root;
        }
    }
}
