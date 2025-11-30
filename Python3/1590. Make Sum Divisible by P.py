class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        total = sum(nums) % p
        if total == 0:
            return 0

        prefix = {0: -1}
        needed = _sum = 0
        l = len(nums)
        ans = l

        for i, n in enumerate(nums):
            _sum = (_sum + n) % p
            needed = (_sum - total + p) % p

            if needed in prefix:
                ans = min(ans, i - prefix[needed])

            prefix[_sum] = i

        return -1 if ans == l else ans