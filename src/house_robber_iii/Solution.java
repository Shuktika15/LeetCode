package house_robber_iii;

import java.util.HashMap;
import java.util.Map;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private final Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (map.get(root) != null)
            return map.get(root);
        int sum1 = root.val;
        int sum2 = 0;
        if (root.left != null) {
            sum1 += rob(root.left.right) + rob(root.left.left);
        }
        if (root.right != null) {
            sum1 += rob(root.right.left) + rob(root.right.right);
        }
        sum2 = rob(root.left) + rob(root.right);
        map.put(root, Math.max(sum1, sum2));
        return map.get(root);
    }
}