class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        N = len(grid)
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        # Check if a move is valid 
        def validMove(r: int, c: int) -> bool:
            return 0 <= r < N and 0 <= c < N

        # Check if there's a path with given min safeness value
        def validSafeness(safeness: int) -> bool:
            if grid[0][0] < safeness or grid[N - 1][N - 1] < safeness:
                return False

            queue = deque([(0, 0)])
            visited = [[False] * N for _ in range(N)]
            visited[0][0] = True

            while queue:
                r, c = queue.popleft()
                # A valid path is found
                if r == N - 1 and c == N - 1:
                    return True

                for i, j in dirs:
                    x, y = r + i, c + j
                    if validMove(x, y) and not visited[x][y] and grid[x][y] >= safeness:
                        visited[x][y] = True
                        queue.append((x, y))

            # No valid path is found
            return False

        thieves = deque()
        end = 0

        # Mark thieves as 0 and empty cells as -1
        for r in range(N):
            for c in range(N):
                if grid[r][c] == 1:
                    thieves.append((r, c))
                    grid[r][c] = 0
                else:
                    grid[r][c] = -1

        # Calculate safeness factor for each cell
        while thieves:
            size = len(thieves)
            for _ in range(size):
                r, c = thieves.popleft()
                val = grid[r][c]
                end = max(end, val)
                for i, j in dirs:
                    x, y = r + i, c + j
                    if validMove(x, y) and grid[x][y] == -1:
                        grid[x][y] = val + 1
                        thieves.append((x, y))
        print(end)

        start = 0
        while start <= end:
            mid = start + (end - start) // 2
            if validSafeness(mid):
                start = mid + 1
            else:
                end = mid - 1

        return end