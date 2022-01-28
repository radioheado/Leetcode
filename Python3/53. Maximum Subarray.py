# One-pass more intuitive
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        right, subsum = 0, 0
        ans = float('-inf')
        
        while right < len(nums):
            subsum += nums[right]
            ans = max(ans, subsum)
            right += 1
            
            # start over if current subarray sums to negative
            if subsum< 0:
                subsum = 0
            
        return ans

# DP
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        # use curArray to store the current cumulative sum of the potential subarray
        # use maxArray to get the maximum sum of all potential subarrays
        curArray = maxArray = nums[0]
        
        # negative sum is not worth keeping
        # when we encounter a negative sum
        # compare it with the maxArray value
        # update it if possible
        # and start a new subarray from the current node
        for num in nums[1:]:
            curArray = max(num, num+curArray)
            maxArray = max(curArray, maxArray)
            
        return maxArray
            
        
        
                
        