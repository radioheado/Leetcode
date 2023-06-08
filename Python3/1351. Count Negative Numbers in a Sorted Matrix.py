class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        n = len(grid[0])
        idx = n - 1
        ans = 0

        for g in grid:
            while idx >= 0 and g[idx] < 0:
                idx -= 1
            ans += n - idx - 1

        return ans
                