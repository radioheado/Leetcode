class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        if k == 1:
            return nums

        N = len(nums)
        ans = [-1] * (N - k + 1)
        prefix = 1

        for i, n in enumerate(nums[1:], 1):
            if n == nums[i - 1] + 1:
                prefix += 1
            else:
                prefix = 1

            if prefix >= k:
                ans[i - k + 1] = n

        return ans