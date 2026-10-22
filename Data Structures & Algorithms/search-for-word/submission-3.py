class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])
        visited = set()

        def dfs(curr, i , j):

            if (i == rows or j == cols
                or i < 0 or j < 0
                or len(curr) > len(word)
                or (i, j) in visited):
                    return False
            
            curr += board[i][j]
            if curr != word[:len(curr)]:
                return False
            visited.add((i, j))
            if curr == word:
                return True
            
            found = (
                dfs(curr, i + 1, j) or
                dfs(curr, i - 1, j) or
                dfs(curr, i, j + 1) or
                dfs(curr, i, j - 1)
            )
            visited.remove((i, j))
            
            return found

        for i in range(rows):
            for j in range(cols):
                if dfs("", i, j):
                    return True
            
        return False