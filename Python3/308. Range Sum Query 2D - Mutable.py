class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.rows, self.cols = len(matrix), len(matrix[0])
        self.size = self.rows * self.cols
        self.tree = [0] * self.size * 2

        for r in range(self.rows):
            for c in range(self.cols):
                self.tree[r * self.cols + c + self.size] = matrix[r][c]

        for i in range(self.size - 1, -1, -1):
            self.tree[i] = self.tree[i * 2] + self.tree[i * 2 + 1]

    def update(self, row: int, col: int, val: int) -> None:
        index = row * self.cols + col + self.size
        self.tree[index] = val

        while index:
            index //= 2
            self.tree[index] = self.tree[index * 2] + self.tree[index * 2 + 1]
        

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        ans = 0
        for r in range(row1, row2 + 1):
            left, right = r * self.cols + col1 + self.size, r * self.cols + col2 + self.size + 1
            while left < right:
                if left % 2:
                    ans += self.tree[left]
                    left += 1
                left //= 2

                if right % 2:
                    right -= 1
                    ans += self.tree[right]
                right //= 2

        return ans


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# obj.update(row,col,val)
# param_2 = obj.sumRegion(row1,col1,row2,col2)