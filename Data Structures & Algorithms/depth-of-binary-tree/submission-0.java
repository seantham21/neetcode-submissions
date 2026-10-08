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
        // BFS or DFS
        // int currMax = 0;

        // while (root != null) {
        //     if (root.left != null)
        // }

        if (root == null) {
            return 0;
        }
        // leaf node
        if ((root.left == null) && (root.right==null)) {
            return 1;
        }

        int currMax = 0;
        int temp = 0;
        if (root.left != null) {
            currMax = 1 + maxDepth(root.left);
        }
        if (root.right != null) {
            temp = 1 + maxDepth(root.right);
        }

        if (currMax > temp) {
            return currMax;
        } else {
            return temp;
        }
    }
}
