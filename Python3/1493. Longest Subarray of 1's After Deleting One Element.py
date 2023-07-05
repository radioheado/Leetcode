class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        l, ans, zero = 0, 0, -1
        for r, n in enumerate(nums):
            if n == 0:
                l = zero + 1
                zero = r
            ans = max(ans, r - l)

        return ans