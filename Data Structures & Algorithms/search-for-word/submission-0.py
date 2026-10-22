class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])
        visited = set()

        def dfs(i, j, k):
            if k == len(word):
                return True

            if (i < 0 or i >= rows or
                j < 0 or j >= cols or
                (i, j) in visited or
                board[i][j] != word[k]):
                return False

            visited.add((i, j))

            found = (
                dfs(i, j - 1, k + 1) or
                dfs(i, j + 1, k + 1) or
                dfs(i - 1, j, k + 1) or
                dfs(i + 1, j, k + 1)
            )

            visited.remove((i, j))

            return found

        for i in range(rows):
            for j in range(cols):
                if dfs(i, j, 0):
                    return True

        return False