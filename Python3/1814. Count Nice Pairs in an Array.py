class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        diffs = collections.defaultdict(int)
        MOD = 10 ** 9 + 7

        def rev(n: int) -> int:
            num = 0
            while n:
                num = num * 10 + n % 10
                n //= 10
            return num
        
        ans = 0
        for n in nums:
            diff = n - rev(n)
            diffs[diff] += 1
            ans = (ans + diffs[diff] - 1) % MOD

        return ans