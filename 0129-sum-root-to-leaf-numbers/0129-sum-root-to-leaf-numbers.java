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
        return find(root, 0);
    }

    private int find(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        int cur = val * 10 + node.val;
        if (node.left == null && node.right == null) {
            return cur;
        }

        return find(node.left, cur) + find(node.right, cur);
    }
}