class Solution:
    def maxSubArrayLen(self, nums: List[int], k: int) -> int:
        # sum_subarray[i:j] = sum([:j]) - sum([:i])
        # dict: key -> cumulative sum from start to this index, value -> indices
        cumu_sum = {}
        
        # add pseudo sum 0, such that sub_sum == k can be counted
        cumu_sum[0] = -1
        
        sub_sum = 0
        res = 0
        
        # cur = sum, find (sum-k)
        # if it's in cumu_sum, update res = max(res, cur_i-pre_i)
        for i, n in enumerate(nums):
            sub_sum += n
            if sub_sum not in cumu_sum:
                cumu_sum[sub_sum] = i
            
            if (sub_sum - k) in cumu_sum:
                res = max(res, i - cumu_sum[sub_sum-k])
                
        return res