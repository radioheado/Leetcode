class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        pivot = None
        count = 0
        
        for n in nums:
            if count == 0:
                pivot = n
            count += (1 if n == pivot else -1)
            
        return pivot