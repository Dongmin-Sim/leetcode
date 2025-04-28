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
    public int sumNumbers(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int preVal) {
        if (node == null) { return preVal; }

        int curVal = preVal * 10 + node.val;
        if (node.left == null && node.right == null) {
            return curVal;
        }

        return dfs(node.left, curVal) + dfs(node.right, curVal);
    }
}