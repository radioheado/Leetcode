class Solution:
    def sumRemoteness(self, grid: List[List[int]]) -> int:
        total_sum, rows, cols = 0, len(grid), len(grid[0])

        dsu = DSU(grid)
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] != -1:
                    total_sum += grid[r][c]
                    if c + 1 < cols and grid[r][c + 1] != -1:
                        dsu.union(r * cols + c, r * cols + c + 1)

                    if r + 1 < rows and grid[r + 1][c] != -1:
                        dsu.union(r * cols + c, (r + 1) * cols + c)

        ans = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] != -1:
                    ans += total_sum - dsu.connectedSum(r * cols + c)

        return ans

class DSU:
    def __init__(self, grid: List[List[int]]) -> None:
        m, n = len(grid), len(grid[0])
        # [i, sum]: i is the root, sum is the sum of this connected sub graph
        self.root = []
        for r in range(m):
            for c in range(n):
                self.root.append([r * n + c, grid[r][c]])

        self.rank = [0] * (m * n)

    def find(self, i: int) -> int:
        if i != self.root[i][0]:
            self.root[i][0] = self.find(self.root[i][0])
        return self.root[i][0]

    def connectedSum(self, i: int) -> int:
        return self.root[self.find(i)][1]

    def union(self, x: int, y: int) -> None:
        rootx, sumx = self.root[self.find(x)]
        rooty, sumy = self.root[self.find(y)]

        if rootx != rooty:
            rankx, ranky = self.rank[rootx], self.rank[rooty]
            if rankx > ranky:
                self.root[rooty][0] = rootx
                self.root[rootx][1] = sumx + sumy
            elif rankx < ranky:
                self.root[rootx][0] = rooty
                self.root[rooty][1] = sumx + sumy
            else:
                self.root[rooty][0] = rootx
                self.root[rootx][1] = sumx + sumy
                self.rank[rankx] += 1