
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
class Solution {

    private Node pre = null;
    private Node head = null;
    private Node last = null;


    public Node treeToDoublyList(Node root) {

        if (root == null)
            return null;

        last = root;
        inOrder(root);
        last.right = head;
        head.left = last;
        return head;
    }

    private void inOrder(Node node) {

        if (node == null)
            return;

        inOrder(node.left);
        node.left = pre;
        if (node.val > last.val)
            last = node;

        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }
}
