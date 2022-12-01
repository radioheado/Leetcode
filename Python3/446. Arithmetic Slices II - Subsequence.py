class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        N = len(nums)
        ans = 0
        dp = [{} for _ in range(N)]
        
        for i, n in enumerate(nums):
            for j in range(i):
                m = nums[j]
                diff = n - m
                prev = dp[j].get(diff, 0)
                curr = dp[i].get(diff, 0)
                dp[i][diff] = prev + curr + 1
                ans += prev
                
        return ans