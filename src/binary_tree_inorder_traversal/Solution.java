package binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    private void inorderTraversal(TreeNode root, List<Integer> lst) {
        if (root != null) {
            inorderTraversal(root.left, lst);
            lst.add(root.val);
            inorderTraversal(root.right, lst);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
}
