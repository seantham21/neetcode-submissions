# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        queue = deque([root])
        lca = root

        while queue:
            curr = queue.popleft()
            if not curr:
                return lca
            if curr.val > p.val and curr.val > q.val:
                queue.append(curr.left)
                lca = curr.left
            elif curr.val < p.val and curr.val < q.val:
                queue.append(curr.right)
                lca = curr.right
            else: 
                return lca
            