# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not subRoot:
            return True
        if not root:
            return False

        q = deque([root])

        while q:
            curr = q.popleft()
            if not curr:
                continue
            stack = [(curr, subRoot)]
            isMatch = True
            while stack:
                nodeR, nodeS = stack.pop()
                if not nodeR and not nodeS:
                    continue
                if (not nodeR or not nodeS 
                    or nodeR.val != nodeS.val):
                    isMatch = False
                    q.append(curr.left)
                    q.append(curr.right)
                    break
                
                stack.append((nodeR.left, nodeS.left))
                stack.append((nodeR.right, nodeS.right))

            if isMatch:
                return True

        return False


                