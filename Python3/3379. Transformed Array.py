class Solution:
    def constructTransformedArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0] * n

        for i, num in enumerate(nums):
            if num > 0:
                idx = (i + num % n) % n
                result[i] = nums[idx]
            elif num < 0:
                num = (-num) % n
                idx = (i - num + n) % n
                result[i] = nums[idx]
            else:
                result[i] = num

        return result