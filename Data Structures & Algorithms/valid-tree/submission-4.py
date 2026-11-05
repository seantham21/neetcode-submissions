class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if n < 2: 
            return True

        adj = {i : [] for i in range(n)}
        for a, b in edges:
            adj[a].append(b)
            adj[b].append(a)
        
        visited = set()
        def dfs(i, parent):
            if i in visited:
                return False

            if adj[i] == []:
                return True
            
            visited.add(i)
            for nei in adj[i]:
                if nei == parent:
                    continue
                if not dfs(nei, i):
                    return False
            adj[i] = []
            return True
        
        return dfs(0, -1) and len(visited) == n

