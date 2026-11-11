class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        count = 0
        rows, cols = len(grid), len(grid[0])

        def dfs(i, j):
            if (i < 0 or i >= rows
                or j < 0 or j >= cols
                or grid[i][j] == "0"):
                return

            grid[i][j] = "0"
            for x, y in directions:
                nr, nc = i + x, j + y
                dfs(nr, nc)

            return

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    dfs(i, j)

        return count