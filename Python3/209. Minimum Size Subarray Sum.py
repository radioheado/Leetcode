class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        # use record to save the locally minimum length of the subarray
        record = float("inf")
        
        # use a sliding window
        left = 0
        
        # use sums to store the sum of the sliding window
        sums = 0
        
        for i, n in enumerate(nums):
            sums += n
            # move left forward until sums - nums[left] < target
            while sums >= target:
                record = min(record, i+1-left)
                sums -= nums[left]
                left += 1
            
        return record if record != float("inf") else 0
                
            
        
        