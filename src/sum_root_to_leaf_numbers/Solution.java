package sum_root_to_leaf_numbers;


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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }

        sum = sum * 10 + root.val;
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }
}
