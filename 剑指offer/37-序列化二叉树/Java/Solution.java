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

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null)
            return null;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode != null) {
                list.add(curNode.val);
            } else {
                list.add(-999);
                continue;
            }

            if (curNode.left != null) {
                queue.add(curNode.left);
            } else {
                queue.add(null);
            }

            if (curNode.right != null) {
                queue.add(curNode.right);
            } else {
                queue.add(null);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == -999)
                list.remove(i);
            else
                break;
        }

        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num != -999)
                res.append(num);
            else
                res.append("null");

            if (i < list.size() - 1)
                res.append(',');
        }
        res.append("]");

//        System.out.println(res.toString());
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null)
            return null;

        data = data.substring(1, data.length() - 1);
        String[] chars = data.split(",");
        for (int i = 0; i < chars.length; i++) {
            if (chars[i].equals("null"))
                chars[i] = "-999";
        }

        if (chars.length == 0)
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(chars[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < chars.length) {
            TreeNode curNode = queue.poll();
            if (Integer.parseInt(chars[i]) != -999) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(chars[i]));
                curNode.left = leftNode;
                queue.add(leftNode);
            } else {
                curNode.left = null;
            }
            i++;

            if (i < chars.length) {
                if (Integer.parseInt(chars[i]) != -999) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(chars[i]));
                    curNode.right = rightNode;
                    queue.add(rightNode);
                } else {
                    curNode.right = null;
                }
                i++;
            } else {
                break;
            }
        }

        return root;
    }


}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

