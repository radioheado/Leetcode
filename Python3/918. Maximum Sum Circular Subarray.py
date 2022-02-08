class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        # mx: max sum so far, mn: min sum so far, sm: cumulative sum
        # gmx: global max sum, gmn; global min sum
        mx = mn = sm = gmx = gmn = nums[0]
        
        for n in nums[1:]:
            sm += n
            mx = max(mx+n, n)
            mn = min(mn+n, n)
            gmx = max(mx, gmx)
            gmn = min(mn, gmn)
        
        # edge case: all nums are negative, return the largest num
        if sm == gmn:
            return gmx
        # otherwise, the total sum minus the global minimum sum should be 
        # the max subarray sum
        else:
            return max(gmx, sm-gmn)
            
        