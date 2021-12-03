class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        maxsofar = nums[0]
        minsofar = nums[0]
        result = maxsofar
        
        for num in nums[1:]:
            # use a temp var to store the max value so far
            # it will be used for computing minsofar
            temp_max = max(num, num*maxsofar, num*minsofar)
            minsofar = min(num, num*maxsofar, num*minsofar)
            # update maxsofar
            maxsofar = temp_max
            
            # update result if possible
            result = max(result, maxsofar)
            
        return result