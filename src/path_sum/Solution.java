package path_sum;

//Definition for a binary tree node
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int sumSoFar) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sumSoFar + root.val == targetSum;
        }
        sumSoFar += root.val;
        return hasPathSum(root.left, targetSum, sumSoFar) || hasPathSum(root.right, targetSum, sumSoFar);
    }
}
