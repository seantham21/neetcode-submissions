# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        q1 = deque([p])
        q2 = deque([q])

        while q1 and q2:
            for _ in range(len(q1)):
                pnode = q1.popleft()
                qnode = q2.popleft()
                if pnode is None and qnode is None:
                    continue
                if (pnode is None) or (qnode is None) or (pnode.val != qnode.val):
                    return False
                
                q1.append(pnode.left)
                q1.append(pnode.right)
                q2.append(qnode.left)
                q2.append(qnode.right)

        return True
