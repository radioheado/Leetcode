class RangeFreqQuery:

    def __init__(self, arr: List[int]):
        self.size = len(arr)
        self.tree = [defaultdict(int) for _ in range(self.size * 2)]

        for i, n in enumerate(arr):
            self.tree[i + self.size][n] += 1

        for i in range(self.size - 1, -1, -1):
            for k, v in self.tree[i * 2].items():
                self.tree[i][k] += v

            for k, v in self.tree[i * 2 + 1].items():
                self.tree[i][k] += v

    def query(self, left: int, right: int, value: int) -> int:
        left += self.size
        right += self.size + 1
        ans = 0

        while left < right:
            if left % 2:
                ans += self.tree[left][value]
                left += 1
            left //= 2

            if right % 2:
                right -= 1
                ans += self.tree[right][value]
            right //= 2

        return ans


# Your RangeFreqQuery object will be instantiated and called as such:
# obj = RangeFreqQuery(arr)
# param_1 = obj.query(left,right,value)