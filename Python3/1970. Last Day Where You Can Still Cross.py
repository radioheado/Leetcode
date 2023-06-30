class Solution:
    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        dsu = DSU(row * col + 2)
        grid = [[1] * col for _ in range(row)]
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        for i in range(len(cells) - 1, -1, -1):
            r, c = cells[i][0] - 1, cells[i][1] - 1
            grid[r][c] = 0
            index1 = r * col + c + 1
            for dr, dc in dirs:
                x, y = r + dr, c + dc
                index2 = x * col + y + 1
                if 0 <= x < row and 0 <= y < col and grid[x][y] == 0:
                    dsu.union(index1, index2)
            
            if r == 0:
                dsu.union(0, index1)
            if r == row - 1:
                dsu.union(row * col + 1, index2)
            if dsu.connected():
                return i
        

class DSU:
    def __init__(self, n: int) -> None:
        self.root = list(range(n))
        self.rank = [0] * n

    def find(self, x: int) -> int:
        if self.root[x] != x:
            self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x: int, y: int) -> None:
        rootx, rooty = self.find(x), self.find(y)
        rankx, ranky = self.rank[rootx], self.rank[rooty]
        if rootx != rooty:
            if rankx > ranky:
                self.root[rooty] = rootx
            elif rankx < ranky:
                self.root[rootx] = rooty
            else:
                self.root[rooty] = rootx
                self.rank[rootx] += 1

    def connected(self) -> bool:
        return self.find(0) == self.find(len(self.root) - 1)