class Solution:
    def maxSum(self, nums: List[int]) -> int:
        uniq = set(nums)
        max_num = -inf
        _sum = 0

        for n in uniq:
            max_num = max(max_num, n)
            _sum += n if n > 0 else 0
        
        if max_num < 0:
            return max_num
        return _sum