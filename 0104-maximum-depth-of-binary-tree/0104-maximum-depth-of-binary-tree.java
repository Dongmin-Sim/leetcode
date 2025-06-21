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
    public int maxDepth(TreeNode root) {
        return dfs(1, root);
    }

    private int dfs(int level, TreeNode node) {
        if (node == null) {
            return level - 1;
        }

        int left = dfs(level + 1, node.left);
        int right = dfs(level + 1, node.right);
        return Math.max(left, right);
    }
}