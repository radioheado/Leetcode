class Solution:
    def specialTriplets(self, nums: List[int]) -> int:
        count = Counter(nums)
        cur_count = Counter()
        MOD = 10 ** 9 + 7
        ans = 0

        for n in nums:
            target = n * 2
            left_count = cur_count[target]
            cur_count[n] += 1
            right_count = count[target] - cur_count[target]
            ans = (ans + left_count * right_count) % MOD

        return ans