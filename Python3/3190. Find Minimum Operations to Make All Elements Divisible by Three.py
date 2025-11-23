class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        ans = 0

        for n in nums:
            if n % 3:
                ans += 1

        return ans