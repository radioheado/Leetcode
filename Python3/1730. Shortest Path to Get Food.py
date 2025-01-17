class Solution:
    def getFood(self, grid: List[List[str]]) -> int:
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        steps = 1
        queue = deque()
        rows, cols = len(grid), len(grid[0])

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '*':
                    queue.append((r, c))
                    grid[r][c] = 'X'
        
        def isValid(x: int, y: int) -> bool:
            return 0 <= x < rows and 0 <= y < cols and grid[x][y] != 'X'

        while queue:
            for _ in range(len(queue)):
                r, c = queue.popleft()
                for i, j in directions:
                    x, y = r + i, c + j
                    if isValid(x, y):
                        if grid[x][y] == '#':
                            return steps

                        grid[x][y] = 'X'
                        queue.append((x, y))
            steps += 1

        return -1