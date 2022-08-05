class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        nums.sort()
        
        @functools.lru_cache(maxsize = None)
        def helper(remain = target):
            if remain == 0:
                return 1
            
            res = 0
            for n in nums:
                if remain - n >= 0:
                    res += helper(remain - n)
                else:
                    break
            
            return res
        
        return helper()