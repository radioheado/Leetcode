class Solution:
    def subarraysWithMoreZerosThanOnes(self, nums: List[int]) -> int:
        prefix = [0]
        balance = 0

        for i, n in enumerate(nums):
            balance += 1 if n == 1 else -1
            prefix.append(balance)
        
        tree = SegmentTree(set(prefix))
        res = 0
        MODULO = 10 ** 9 + 7

        for p in prefix:
            res += tree.query(p)
            res %= MODULO
            tree.update(p)
        
        return res


class SegmentTree:
    def __init__(self, unique_prefix: set) -> None:
        self.val_to_idx = {val: i for i, val in enumerate(sorted(unique_prefix))}
        self.size = len(self.val_to_idx)
        self.tree = [0] * 2 * self.size

    def update(self, val: int) -> None:
        idx = self.val_to_idx[val] + self.size
        self.tree[idx] += 1
        while idx:
            idx //= 2
            self.tree[idx] = self.tree[idx * 2] + self.tree[idx * 2 + 1]

    def query(self, val: int) -> int:
        ans = 0
        l, r = self.size, self.size + self.val_to_idx[val]
        while l < r:
            if l % 2:
                ans += self.tree[l]
                l += 1
            l //= 2

            if r % 2:
                r -= 1
                ans += self.tree[r]
            r //= 2

        return ans
