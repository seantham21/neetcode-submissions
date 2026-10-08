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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        TreeNode curr = root;
        boolean isSub;

        while (!q1.isEmpty()) {
            curr = q1.poll();
            isSub = compare(curr, subRoot);
            if (isSub) { 
                return true; 
            } else {
                if (curr != null) {
                    q1.add(curr.left);
                    q1.add(curr.right);
                } 
            }
        }

        return false;
    }

    public boolean compare (TreeNode root, TreeNode sub) {
        if ((root == null) && (sub == null)) {
            return true;
        }

        if ((root == null) || (sub == null) 
            || (root.val != sub.val)) {
            return false;
        }

        return compare(root.left, sub.left) && compare(root.right, sub.right);
    }
}
