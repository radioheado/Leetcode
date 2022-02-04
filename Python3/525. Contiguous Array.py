class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        prefix = {0: -1}
        count = 0
        ans = 0
        
        for i, n in enumerate(nums):
            if n == 0:
                count -= 1
            else:
                count += 1
                
            if count in prefix:
                ans = max(ans, i - prefix[count])
            else:
                prefix[count] = i
                
        return ans
                
        