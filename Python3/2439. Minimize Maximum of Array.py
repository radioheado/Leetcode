class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        prefix = 0
        ans = 0

        for i, n in enumerate(nums):
            prefix += n
            ans = max(ans, math.ceil(prefix / (i+1)))

        return ans