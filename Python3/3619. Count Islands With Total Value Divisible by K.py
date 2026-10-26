class Solution:
    def countIslands(self, grid: List[List[int]], k: int) -> int:
        rows, cols = len(grid), len(grid[0])
        dsu = DSU(grid)

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 0:
                    continue

                if r > 0 and grid[r - 1][c] > 0:
                    dsu.union(r * cols + c, (r - 1) * cols + c)
                if c > 0 and grid[r][c - 1] > 0:
                    dsu.union(r * cols + c, r * cols + (c - 1))

        return dsu.count(k)        


class DSU:
    def __init__(self, grid: List[List[int]]) -> None:
        rows, cols = len(grid), len(grid[0])
        self.root = list(range(rows * cols))
        self.rank = [0] * rows * cols
        self.vals = []
        for row in grid:
            for cell in row:
                self.vals.append(cell)

    def find(self, x: int) -> int:
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x: int, y: int) -> None:
        rootx, rooty = self.find(x), self.find(y)
        rankx, ranky = self.rank[rootx], self.rank[rooty]
        if rootx != rooty:
            if rankx > ranky:
                self.root[rooty] = rootx
                self.vals[rootx] += self.vals[rooty]
                self.vals[rooty] = 0
            elif rankx < ranky:
                self.root[rootx] = rooty
                self.vals[rooty] += self.vals[rootx]
                self.vals[rootx] = 0
            else:
                self.root[rooty] = rootx
                self.rank[rootx] += 1
                self.vals[rootx] += self.vals[rooty]
                self.vals[rooty] = 0

    def count(self, k: int) -> int:
        ans = 0
        print(self.vals)
        for val in self.vals:
            if val != 0 and val % k == 0:
                ans += 1

        return ans
