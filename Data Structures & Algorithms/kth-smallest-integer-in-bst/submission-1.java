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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = root;
        
        while ((curr != null) && (curr.left != null)) {
            stack.push(curr.left);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            TreeNode smallest = stack.pop();
            if (k == 1) {
                return smallest.val;
            }

            k--;
            if (smallest.right != null) {
                stack.push(smallest.right);
                curr = smallest.right;
                while ((curr != null) && (curr.left != null)) {
                    stack.push(curr.left);
                    curr = curr.left;
                }        
            }
        }
        return root.val;
    
    }
}
