# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q = deque([root])
        res = []

        while q:
            temp = []            
            for _ in range(len(q)):
                curr = q.popleft()
                if not curr:
                    continue
                
                temp.append(curr.val)
                q.append(curr.left)
                q.append(curr.right)
            
            if len(temp) > 0:
                res.append(temp)
        
        return res


            