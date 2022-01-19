class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        prefix = collections.defaultdict(int)
        prefix[0] = 1
        subsum = 0
        res = 0
        
        for i, n in enumerate(nums):
            subsum = (subsum+n)%k
            
            if subsum in prefix:
                res += prefix[subsum]
                
            prefix[subsum] += 1
            
        return res