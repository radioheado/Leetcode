class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        vals = Counter(nums)
        ans = 0

        for v in vals.values():
            if v > 1:
                ans += v * (v - 1) // 2

        return ans