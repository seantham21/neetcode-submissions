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
    public boolean isBalanced(TreeNode root) {
        return helper(root)[0] == 1;
    }

    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{1,0};
        }
        
        int[] left = new int[]{1,0};
        int[] right = new int[]{1,0};
        if (root.left != null) {
            left = helper(root.left);
        }
        if (root.right != null) {
            right = helper(root.right);
        }

        if (((left[0] == 1) && (right[0] == 1)) 
            && (Math.abs(left[1] - right[1]) <= 1)) {
                return new int[]{1, 1 + Math.max(left[1], right[1])};
        } else {
            return new int[]{0, 1 + Math.max(left[1], right[1])};
        }
    }
}
