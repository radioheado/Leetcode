class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        heap = [(grid[0][0], 0, 0)]
        visited = {(0, 0)}
        ans = 0
        directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]

        def isValid(x: int, y: int) -> bool:
            return 0 <= x < n and 0 <= y < n and (x, y) not in visited

        while heap:
            cur_time, i, j = heappop(heap)
            ans = max(ans, cur_time)
            if i == j == n - 1:
                return ans

            for di, dj in directions:
                r, c = i + di, j + dj
                if isValid(r, c):
                    visited.add((r, c))
                    heappush(heap, (grid[r][c], r, c))

        return ans