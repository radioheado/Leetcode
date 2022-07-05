class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        ans = 0
        num = set(nums)
        
        for i in num:
            if i-1 not in num:
                current, tmp = i, 1
                
                while current+1 in num:
                    current += 1
                    tmp += 1
                
                ans = max(ans, tmp)
                
        return ans