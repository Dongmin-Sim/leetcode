import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        traversal(res, root, 0);
        return res;
    }

    public void traversal(List<List<Integer>> res, TreeNode root, int level) {
        // 종료 조건
        if (root == null) return;

        // level 초기화
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        // 전위 순회  (나 - 왼 - 오)
        res.get(level).add(root.val);

        traversal(res, root.left, level + 1);
        traversal(res, root.right, level + 1);
    }
}