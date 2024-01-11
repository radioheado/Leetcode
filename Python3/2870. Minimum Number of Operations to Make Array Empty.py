class Solution:
    def minOperations(self, nums: List[int]) -> int:
        counts = Counter(nums)
        ans = 0

        for c in counts.values():
            if c == 1:
                return -1
            ans += ceil(c / 3)

        return ans