class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        
        three = set()
        
        for num in nums:
            three.add(num)
            if len(three) > 3:
                three.remove(min(three))
                
                
        if len(three) == 3:
            return min(three)
        else:
            return max(three)
        