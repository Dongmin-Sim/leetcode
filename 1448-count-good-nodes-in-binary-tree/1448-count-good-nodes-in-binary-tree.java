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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) { return 0; }

        int goodNum = 0;

        if (node.val >= max) {
            goodNum++;
            max = Math.max(node.val, max);
        }

        goodNum += dfs(node.left, max);
        goodNum += dfs(node.right, max);

        return goodNum;
    }
}