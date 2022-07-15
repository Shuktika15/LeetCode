package path_sum_ii;


import java.util.ArrayList;
import java.util.List;


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

public class Solution {
    int count = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum, int sumSoFar, List<List<Integer>> lst, List<Integer> sublst) {
        if (root.left == null && root.right == null && targetSum == sumSoFar) {
            lst.add(new ArrayList<Integer>(sublst));
        }
        if (root.right != null) {
            sublst.add(root.right.val);
            pathSum(root.right, targetSum, sumSoFar + root.right.val, lst, sublst);
        }

        if (root.left != null) {
            sublst.add(root.left.val);
            pathSum(root.left, targetSum, sumSoFar + root.left.val, lst, sublst);
        }
        sublst.remove(sublst.size() - 1);


        return lst;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        List<Integer> sublst = new ArrayList<Integer>();
        if (root == null)
            return lst;
        sublst.add(root.val);
        return pathSum(root, targetSum, root.val, lst, sublst);

    }
}
