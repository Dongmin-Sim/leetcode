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
    
    int max = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        maxZigZag(root.left, "left", 1);
        maxZigZag(root.right, "right", 1);

        return max;
    }

    private void maxZigZag(TreeNode node, String direction, int length) {
        if (node == null) {
            return;
        }

        max = Math.max(max, length);

        if (direction.equals("left")) {
            maxZigZag(node.right, "right", length + 1);
            maxZigZag(node.left, "left", 1);
        } else {
            maxZigZag(node.right, "right", 1);
            maxZigZag(node.left, "left", length + 1);
        }
    }
}