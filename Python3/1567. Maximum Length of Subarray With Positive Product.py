class Solution:
    def getMaxLen(self, nums: List[int]) -> int:
        
        start = ans = 0
        prod = 1
        
        for i, n in enumerate(nums):
            if n > 0:
                n = 1
            elif n < 0:
                n = -1
                
            prod *= n
            
            if prod == 0:
                prod = 1
                start = i+1
            elif prod < 0 and (i == len(nums)-1 or nums[i+1] == 0):
                while start <= i and prod < 0:
                    if nums[start] < 0:
                        prod *= -1
                    start += 1
                    
            if prod > 0:
                ans = max(ans, i - start + 1)
                    
            #print(prod, start, ans)
                
        return ans