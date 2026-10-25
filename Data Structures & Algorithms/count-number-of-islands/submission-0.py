class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        visited = set()
        islands = 0

        def bfs(r, c):
            q = deque([(r, c)])
            visited.add((r, c))
            while q:
                currR, currC = q.popleft()
                directions = [(currR, currC - 1), (currR, currC + 1), 
                    (currR - 1, currC), (currR + 1, currC)]
                for dr, dc in directions:
                    if (dr in range(rows) and dc in range(cols)
                        and grid[dr][dc] == "1" 
                        and (dr, dc) not in visited): 
                            q.append((dr, dc))
                            visited.add((dr, dc))

        for r in range(rows):
            for c in range(cols):
                if (grid[r][c] == "1") and ((r, c) not in visited): 
                    bfs(r, c)
                    islands += 1

        return islands