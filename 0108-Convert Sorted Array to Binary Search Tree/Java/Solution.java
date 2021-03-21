class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;
        int rootOfIndex = len / 2;
        TreeNode root = new TreeNode(nums[rootOfIndex]);
        root.left = buildTree(nums, 0, rootOfIndex);
        root.right = buildTree(nums, rootOfIndex + 1, len);

        return root;
    }

    private  TreeNode buildTree(int[] nums, int i, int j) {

        if (j <= i)
            return null;

        int len = j - i;
        int rootOfIndex = i + len / 2;
        TreeNode root = new TreeNode(nums[rootOfIndex]);
        root.left = buildTree(nums, i, rootOfIndex);
        root.right = buildTree(nums, rootOfIndex + 1, j);

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10,-3,0,5,9};
        solution.sortedArrayToBST(nums);
    }
}
