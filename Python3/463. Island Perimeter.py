class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        R, C = len(grid), len(grid[0])
        ans = 0

        for r in range(R):
            for c in range(C):
                if grid[r][c] == 1:
                    ans += 4
                    if r > 0 and grid[r-1][c] == 1:
                        ans -= 2
                    if c > 0 and grid[r][c-1] == 1:
                        ans -= 2

        return ans