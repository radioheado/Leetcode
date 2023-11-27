class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        left_sum = 0
        right_sum = sum(nums)
        size = len(nums)
        ans = [-1] * size

        for i, n in enumerate(nums):
            val = n * i - left_sum + right_sum - n * (size - i)
            ans[i] = val
            left_sum += n
            right_sum -= n

        return ans