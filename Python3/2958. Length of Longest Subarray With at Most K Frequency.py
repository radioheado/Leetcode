class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        count = collections.defaultdict(int)
        l = ans = 0

        for r, n in enumerate(nums):
            count[n] += 1
            while count[n] > k:
                left = nums[l]
                count[left] -= 1
                l += 1
                
            ans = max(ans, r - l + 1)

        return ans
