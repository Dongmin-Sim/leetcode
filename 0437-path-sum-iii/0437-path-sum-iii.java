/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return dfs(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode node, int targetSum, long accVal) {
        if (node == null) {return 0;}
        accVal += node.val;
        int count = 0;
        if (accVal == targetSum) {count++;}
        count += dfs(node.left, targetSum, accVal);
        count += dfs(node.right, targetSum, accVal);

        return count;
    }
}