class Solution:
    def minElement(self, nums: List[int]) -> int:
        ans = inf
        for num in nums:
            _sum = 0
            while num:
                _sum += num % 10
                num //= 10
            ans = min(ans, _sum)
        return ans