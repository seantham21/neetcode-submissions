class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])
        visited = set()

        def dfs(curr, i , j):

            if (i == rows or j == cols
                or i < 0 or j < 0
                or len(curr) > len(word)
                or (i, j) in visited
                or curr + board[i][j] != word[:len(curr + board[i][j])]):
                    return False
            
            curr = curr + board[i][j]
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