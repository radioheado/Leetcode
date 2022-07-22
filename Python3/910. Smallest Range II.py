class Solution:
    def smallestRangeII(self, nums: List[int], k: int) -> int:
        if len(nums) < 2:
            return 0
        
        nums.sort()
        mi, ma = nums[0]+k, nums[-1]-k
        ans = nums[-1] - nums[0]
        
        for i, b in enumerate(nums[1:], 1):
            a = nums[i-1]
            ans = min(ans, max(ma, a+k) - min(mi, b-k))
            
        return ans