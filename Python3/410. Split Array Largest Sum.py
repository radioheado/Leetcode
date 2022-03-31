# DP solution: TLE
class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        N = len(nums)
        
        # calculate the prefix sum
        for i in range(1, N):
            nums[i] += nums[i-1]
        
        # dp[i][j]: best sum to split nums[:j+1] to i groups
        # dp[1][j] = sum(nums[:j+1]) 
        # dp[i][j] = min(max(dp[i-1][k]), sum(k+1, j)) where 0 <= k < j
        dp = [[inf]*N for _ in range(m+1)]
        for i in range(N):
            dp[1][i] = nums[i]
        
        for i in range(2, m+1):
            for j in range(i-1, N):
                for k in range(j):
                    dp[i][j] = min(dp[i][j], max(dp[i-1][k], nums[j]-nums[k]))
        
        return dp[-1][-1]

# Binary Search
class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        N = len(nums)
        left = nums[0]
        for i in range(1, N):
            left = max(left, nums[i])
            nums[i] += nums[i-1]
        #print(left)    
        right = nums[-1]+1
        while left < right:
            mid = (right-left)//2 + left
            #print("current limit: ", mid)
            if self.groups(nums, mid) > m:
                left = mid+1
            else:
                right = mid
        return left

    def groups(self, nums, limit):
        group = 1
        prev = 0
        for i, n in enumerate(nums):
            #print("current sum: ", n-prev)
            if n-prev > limit:
                group += 1
                prev = nums[i-1]
        return group