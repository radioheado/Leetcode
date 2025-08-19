class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        ans = zeroes = 0
        for num in nums:
            if num == 0:
                zeroes += 1
            else:
                zeroes = 0

            ans += zeroes
        
        return ans