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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodes1 = new ArrayList<>();
        List<Integer> leafNodes2 = new ArrayList<>();

        dfs(root1, leafNodes1);
        dfs(root2, leafNodes2);

        if (leafNodes1.size() != leafNodes2.size()) {
            return false;
        }

        for (int i = 0; i < leafNodes1.size(); i++) {
            if (!leafNodes1.get(i).equals(leafNodes2.get(i))) {
                return false;
            }
        }

        return true;
    }

    private void dfs(TreeNode node, List<Integer> leafNodes) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafNodes.add(node.val);
            return;
        }

        dfs(node.left, leafNodes);
        dfs(node.right, leafNodes);
    }
}