import java.util.*;

class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();

        if (root == null)
            return lists;

        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            Stack<Integer> temp = new Stack<>();
            int cnt = queue.size();

            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (flag)
                    temp.push(node.val);
                else {
                    list.add(node.val);
                }
                queue.add(node.left);
                queue.add(node.right);
            }

            if (flag) {
                while (!temp.isEmpty()) {
                    list.add(temp.pop());
                }
            }
            flag = !flag;
            if (list.size() != 0)
                lists.add(list);
        }

        return lists;
    }
}
