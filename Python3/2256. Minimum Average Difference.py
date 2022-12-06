class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        N = len(nums)
        if N == 1:
            return 0
        
        for i in range(1, N):
            nums[i] += nums[i-1]
        
        idx = -1
        diff = inf
        total = nums[-1]
        
        for i, n in enumerate(nums):
            avg1 = n // (i + 1)
            avg2 = ((total - n) // (N - i - 1)) if N > (i + 1) else 0
            avg = abs(avg1 - avg2)
            if avg < diff:
                idx = i
                diff = avg
                
        return idx