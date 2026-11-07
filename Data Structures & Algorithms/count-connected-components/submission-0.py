class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adj = {i:[] for i in range(n)}
        for a, b in edges:
            adj[a].append(b)
            adj[b].append(a)
        
        visited = set()
        count = 0
        def dfs(i):
            if i in visited:
                return False
            
            visited.add(i)
            for nei in adj[i]:
                dfs(nei)
            
            return True
        
        for i in range(n):
            if dfs(i):
                count += 1
        
        return count
            