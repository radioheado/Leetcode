class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        l = 0
        ans = 1
        used = 0

        for r, n in enumerate(nums[1:], 1):
            used += (r - l) * (n - nums[r - 1])

            #print(used, streak)
            while l < r and used > k:
                used -= n - nums[l]
                l += 1

            ans = max(ans, r - l + 1)

        return ans
