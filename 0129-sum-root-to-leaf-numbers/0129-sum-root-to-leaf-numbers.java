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
        return calculatePathSum(root, 0, 0);
    }

    private int calculatePathSum(TreeNode node, int prev, int sum) {
        if (node == null) return 0;

        int cur = prev * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += cur;
            return sum;
        }

        int left = calculatePathSum(node.left, cur, sum);
        int right = calculatePathSum(node.right, cur, sum);
        return left + right;
    }
}