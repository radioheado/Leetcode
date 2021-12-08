class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        def dfs(nums, i, sums, memo):
            #print(i, sums, memo)
            
            if (i, sums) in memo:
                return memo[(i, sums)]
            
            # reaches the end of the nums array
            # the check condition is i == len(nums) because
            # we perform dfs(.., i+1, ..) before 
            if i == len(nums):
                return target == sums
            
            count = 0
            count += dfs(nums, i+1, sums+nums[i], memo)
            count += dfs(nums, i+1, sums-nums[i], memo)
            memo[(i, sums)] = count
            return count
        
        memo = {}
        
        return dfs(nums, 0, 0, memo)
        
        