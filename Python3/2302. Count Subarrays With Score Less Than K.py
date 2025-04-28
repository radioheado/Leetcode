class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        ans = prefix = l = 0
        for r, n in enumerate(nums):
            prefix += n
            while l <= r and prefix * (r - l + 1) >= k:
                prefix -= nums[l]
                l += 1

            ans += r - l + 1

        return ans