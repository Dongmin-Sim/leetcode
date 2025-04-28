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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, targetSum, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> tmp, int sum) {
        if (root == null) {
            return;
        }

        tmp.add(root.val);

        int curVal = sum + root.val;
        if (root.left == null && root.right == null) {
            if (curVal == targetSum) {
                result.add(new ArrayList<>(tmp));
            }
        }
        dfs(root.left, targetSum, result, tmp, curVal);
        dfs(root.right, targetSum, result, tmp, curVal);

        tmp.remove(tmp.size() - 1);
    }
}