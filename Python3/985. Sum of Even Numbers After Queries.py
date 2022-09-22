class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        
        def odd(n):
            return n % 2 == 1
        
        def even(n):
            return n % 2 == 0
        
        # query: [value, index]
        even_sum = 0
        for n in nums:
            if even(n):
                even_sum += n
                
        ans = []
        for val, i in queries:
            cur = nums[i]
            after = val + cur
            nums[i] = after
            
            if odd(cur) and even(after):
                even_sum += after
                
            elif even(cur) and odd(after):
                even_sum -= cur
                
            elif even(cur) and even(after):
                even_sum += val
                
            ans.append(even_sum)
            
        return ans
            
    
        