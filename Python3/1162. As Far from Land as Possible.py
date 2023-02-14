class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:

        def manhattan(p1: List[int], p2: List[int]) -> int:
            return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])

        R, C = len(grid), len(grid[0])

        q = deque()
        for r in range(R):
            for c in range(C):
                if grid[r][c] == 1:
                    q.append([(r, c), 0])

        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        ans = 0
        while q:
            size = len(q)
            for _ in range(size):
                (r, c), dis = q.popleft()
                for i, j in dirs:
                    x, y = r + i, c + j
                    if 0 <= x < R and 0 <= y < C and grid[x][y] == 0:
                        grid[x][y] = 1
                        q.append([(x, y), dis + 1])

            ans = max(ans, dis)

        return ans if ans != 0 else -1
            