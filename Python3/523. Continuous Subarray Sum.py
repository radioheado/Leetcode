class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        # only one element in nums is definitely a False
        if len(nums) == 1:
            return False
        
        # *IMPORTANT*:
        # 0 is also a multiple of k!
        # but one 0 is not correct, there should be at least two elements add up to 0
        remainder = {0: -1}
        total = 0
        
        for i in range(len(nums)):
            total += nums[i]
            rem = total%k
            
            # the distance between two same remainders should be greater than 1
            # such that there are at least two elements in the subarray
            if rem in remainder:
                if i-remainder.get(rem) > 1:
                    return True
            else:
                remainder[rem] = i
                
        return False