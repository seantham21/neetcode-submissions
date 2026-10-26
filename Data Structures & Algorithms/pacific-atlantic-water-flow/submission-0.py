class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows = len(heights)
        cols = len(heights[0])
        res = []
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def dfs(sr, sc):
            visited = set()
            visited.add((sr, sc))
            stack = [(sr, sc)]

            curr = [False, False]

            while stack:
                r, c = stack.pop()

                if r == 0 or c == 0:
                    curr[0] = True

                if r == rows - 1 or c == cols - 1:
                    curr[1] = True

                if curr[0] and curr[1]:
                    return True

                for dr, dc in directions:
                    nr, nc = r + dr, c + dc

                    if (0 <= nr < rows
                        and 0 <= nc < cols
                        and (nr, nc) not in visited
                        and heights[nr][nc] <= heights[r][c]):

                        visited.add((nr, nc))
                        stack.append((nr, nc))

            return False

        for r in range(rows):
            for c in range(cols):
                if dfs(r, c):
                    res.append([r, c])

        return res