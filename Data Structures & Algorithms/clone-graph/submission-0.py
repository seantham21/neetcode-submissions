"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None

        if len(node.neighbors) == 0: 
            return Node(node.val)
        
        res = Node(node.val)
        q = deque([(node)])
        mapping = {}
        mapping[node] = res

        while q:
            curr = q.popleft()
            for neighbor in curr.neighbors:
                if neighbor not in mapping:
                    new = Node(neighbor.val)
                    mapping[neighbor] = new
                    q.append(neighbor)
                
                mapping[curr].neighbors.append(mapping[neighbor])
        
        return res

            