class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        ans = 0
        l = len(nums)

        for i in range(l // 2):
            ans = max(ans, nums[i] + nums[l - i - 1])

        return ans