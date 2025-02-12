class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        digit_sum = [0] * 82
        ans = -1

        for n in nums:
            ds = sum(int(c) for c in str(n))
            if digit_sum[ds] > 0:
                ans = max(ans, digit_sum[ds] + n)
            digit_sum[ds] = max(digit_sum[ds], n)
       
        return ans