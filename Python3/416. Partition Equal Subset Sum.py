class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False
        
        subtotal = total // 2
        dp = [False] * (subtotal + 1)
        dp[0] = True
        
        for n in nums:
            for j in range(subtotal, n - 1, -1):
                dp[j] = dp[j] or dp[j - n]
                
        return dp[subtotal]
        