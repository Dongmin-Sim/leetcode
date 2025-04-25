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

        findDuplicateSubtree(root, map, result);
        return result;
    }

    private String findDuplicateSubtree(TreeNode node, HashMap<String, Integer> map, List<TreeNode> result) {
        if (node == null) return "";

        String left = findDuplicateSubtree(node.left, map, result);
        String right = findDuplicateSubtree(node.right, map, result);
        String serialized = String.join("|", String.valueOf(node.val), left, right);

        map.put(serialized, map.getOrDefault(serialized, 0) + 1);
        if (map.getOrDefault(serialized, 0) == 2) {
            result.add(node);
        }

        return serialized;
    }
}