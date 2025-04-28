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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();

        findDuplicate(root, map, result);
        return result;
    }

    private String findDuplicate(TreeNode node, HashMap<String, Integer> map, List<TreeNode> result) {
        if (node == null) return "";

        String left = findDuplicate(node.left, map, result);
        String right = findDuplicate(node.right, map, result);
        String key = String.join("|", String.valueOf(node.val), left, right);

        map.put(key, map.getOrDefault(key, 0) + 1);

        if (map.getOrDefault(key, 0) == 2) {
            result.add(node);
        }

        return key;
    }
}