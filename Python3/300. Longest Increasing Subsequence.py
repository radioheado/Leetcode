class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        L = len(nums)
        dp = [1] * L
        ans = 1
        
        for i in range(1, L):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j]+1)
            ans = max(ans, dp[i])
                
        return ans