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
    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int depth) {
        if (root == null) { return 0; }

        int left = depth;
        int right = depth;
        if (root.left != null) {
            left = dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            right = dfs(root.right, depth + 1);
        }
        return Math.max(left, right);
    }
}
