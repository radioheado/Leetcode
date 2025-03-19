class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        ans = 1
        used_bits = l = 0

        for r, n in enumerate(nums):
            while used_bits & n != 0:
                used_bits ^= nums[l]
                l += 1

            used_bits |= n
            ans = max(ans, r - l + 1)

        return ans