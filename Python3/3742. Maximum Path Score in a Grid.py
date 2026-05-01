class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[[-1] * min(m + n, k + 1) for _ in range(n)] for _ in range(m)]
        dp[0][0][0] = 0

        # Do the first row
        for c in range(1, n):
            cur_cost = grid[0][c] != 0
            for prev_cost, score in enumerate(dp[0][c - 1]):
                total_cost = prev_cost + cur_cost
                if score != -1 and total_cost <= k:
                    dp[0][c][total_cost] = max(dp[0][c][total_cost], score + grid[0][c])
        

        # Do the first column
        for r in range(1, m):
            cur_cost = grid[r][0] != 0
            for prev_cost, score in enumerate(dp[r - 1][0]):
                total_cost = prev_cost + cur_cost
                if score != -1 and total_cost <= k:
                    dp[r][0][total_cost] = max(dp[r][0][total_cost], score + grid[r][0])

        for r in range(1, m):
            for c in range(1, n):
                cur_cost = grid[r][c] != 0
                for prev_cost, score in enumerate(dp[r - 1][c]):
                    total_cost = prev_cost + cur_cost
                    if score != -1 and total_cost <= k:
                        dp[r][c][total_cost] = max(dp[r][c][total_cost], score + grid[r][c])

                for prev_cost, score in enumerate(dp[r][c - 1]):
                    total_cost = prev_cost + cur_cost
                    if score != -1 and total_cost <= k:
                        dp[r][c][total_cost] = max(dp[r][c][total_cost], score + grid[r][c])

        return max(dp[m - 1][n - 1])
