class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        # add (0:1) to count for sum = k
        # such that sum-k = 0
        sums = {0: 1}
        total = 0
        count = 0
        
        for n in nums:
            total += n
            if total-k in sums:
                count += sums.get(total-k)
                
            # update the count of the current sum
            sums[total] = sums.get(total, 0)+1
                
        return count