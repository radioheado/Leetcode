class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        max_i = max_diff = ans = 0

        for num in nums:
            ans = max(ans, max_diff * num)
            max_diff = max(max_diff, max_i - num)
            max_i = max(max_i, num)

        return ans