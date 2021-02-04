import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int cnt = queue.size();
            while (cnt -- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                temp.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (temp.size() != 0)
                list.add(temp);
        }

        return list;
    }
}
