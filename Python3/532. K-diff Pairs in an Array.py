class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        nums = collections.Counter(nums)
        ans = 0
        
        for n, count in nums.items():
            if k > 0 and n + k in nums:
                ans += 1
                
            if k == 0 and count > 1:
                ans += 1
                
        return ans