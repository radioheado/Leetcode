class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        counts = [0] * 101
        totalf = 0
        maxf = 0

        for n in nums:
            counts[n] += 1
            curf = counts[n]
            if curf > maxf:
                maxf = curf
                totalf = curf
            elif curf == maxf:
                totalf += curf

        return totalf