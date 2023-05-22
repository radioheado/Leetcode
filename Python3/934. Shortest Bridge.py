class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        n = len(grid)
        q = collections.deque()
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def dfs(r: int, c: int) -> None:
            grid[r][c] = 2
            q.append((r, c))
            for i, j in dirs:
                if 0 <= r + i < n and 0 <= c + j < n and grid[r + i][c + j] == 1:
                    dfs(r+i, c+j)
                    
        x = y = -1
        for r in range(n):
            for c in range(n):
                if grid[r][c] == 1:
                    x = r
                    y = c
                    break
        dfs(x, y)
        distance = 0

        while q:
            size = len(q)
            for _ in range(size):
                r, c = q.popleft()
                for i, j in dirs:
                    if 0 <= r + i < n and 0 <= c + j < n:
                        if grid[r + i][c + j] == 1:
                            return distance
                        elif grid[r + i][c + j] == 0:
                            q.append((r + i, c + j))
                            grid[r + i][c + j] = -1

            distance += 1
        return -1