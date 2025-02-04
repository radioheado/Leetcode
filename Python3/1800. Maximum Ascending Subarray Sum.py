class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        ans = prefix = nums[0]

        for i, n in enumerate(nums[1:], 1):
            if n > nums[i - 1]:
                prefix += n
            else:
                prefix = n
            ans = max(ans, prefix)

        return ans