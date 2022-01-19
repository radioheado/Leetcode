class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # for a dup num, the number less or equal than it is greater than itself
        # e.g. nums -> [1,2,2,3], count -> [1,3,3,4]
        #      if num < count:  the dup num is equal or smaller than current num
        #      otherwise, the dup num is greater than current num
        
        left, right = 1, len(nums)-1
        
        while left <= right:
            cur = (right-left)//2 + left
            count = sum(num <= cur for num in nums)
            
            if cur < count:
                dup = cur
                right = cur-1
                
            else:
                left = cur+1
                
        return dup