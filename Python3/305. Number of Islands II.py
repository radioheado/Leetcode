class Solution:
    def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
        if not positions:
            return []

        count = 0
        ans = []
        dsu = DSU(m, n)
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        for x, y in positions:
            landPos = x * n + y
            dsu.addLand(landPos)

            for i, j in dirs:
                neiX, neiY = x + i, y + j
                neiPos = neiX * n + neiY

                if 0 <= neiX < m and 0 <= neiY < n and dsu.isIsland(neiPos):
                    dsu.union(landPos, neiPos)

            ans.append(dsu.numberOfIslands())
                            
        return ans

class DSU:
    def __init__(self, m, n):
        # use this list to keep the island each grid belongs to
        # the format is: self.island[i*n+j] = x*n+y, where [i, j] and [x, y] are coordinates
        self.island = [-1] * m * n
        self.islands = 0
        self.rank = [1] * m * n
        
    # [x, y] is the location of the node
    def find(self, x: int) -> int:
        if x != self.island[x]:
            self.island[x] = self.find(self.island[x])
        return self.island[x]
    
    def union(self, a: int, b: int) -> None:
        x = self.find(a)
        y = self.find(b)
        
        # a and b have the same root, which means they are already connected
        # thus, we don't need to update the cost
        if x == y:
            return 
        
        self.islands -= 1
        # different roots, merge the two nodes
        if self.rank[x] < self.rank[y]:
            self.island[x] = y
        elif self.rank[x] > self.rank[y]:
            self.island[y] = x
        else:
            self.island[x] = y
            self.rank[y] += 1

    def numberOfIslands(self) -> int:
        return self.islands

    def isIsland(self, x: int) -> bool:
        return True if self.island[x] >= 0 else False

    def addLand(self, x: int) -> None:
        if self.island[x] < 0:
            self.island[x] = x
            self.islands += 1
        