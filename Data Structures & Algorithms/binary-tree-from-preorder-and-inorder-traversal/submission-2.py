# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # HashMap of location of that node
        pos = {}
        for i in range(len(inorder)):
            pos[inorder[i]] = i

        k = 0

        def build(l, r):
            if l > r:
                return None
            
            nonlocal k
            
            midVal = preorder[k]
            currPos = pos[midVal]
            currNode = TreeNode(midVal)
            k += 1

            currNode.left = build(l, currPos - 1)
            currNode.right = build(currPos + 1, r)

            return currNode

        return build(0, len(inorder) - 1)

        