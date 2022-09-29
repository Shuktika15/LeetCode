package populating_next_right_pointers_in_each_node;

public class Solution {
    public Node getNextForRight(Node root) {
        if (root == null) {
            return null;
        }
        return root.left;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextForRight(root.next);
        }
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }
}
