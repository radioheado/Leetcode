class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        ans = 0
        rows, cols = len(grid), len(grid[0])
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def backtrack(r = 0, c = 0, visited = set(), gold = 0) -> None:
            if r < 0 or r >= rows or c < 0 or c >= cols or (r, c) in visited or grid[r][c] == 0:
                return

            nonlocal ans
            ans = max(gold + grid[r][c], ans)
            visited.add((r, c))

            for i, j in dirs:
                x = r + i
                y = c + j
                backtrack(x, y, visited, gold + grid[r][c])
            
            visited.discard((r, c))

        for r in range(rows):
            for c in range(cols):
                backtrack(r, c)
        return ans