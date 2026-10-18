# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        curr = (root, float('-inf'), float('inf'))
        q = deque([curr])

        while q:
            node, low, high = q.popleft()
            if not node:
                continue
            
            if node.val <= low or node.val >= high: 
                return False
            else:
                q.append((node.left, low, node.val))
                q.append((node.right, node.val, high))
        
        return True
            
