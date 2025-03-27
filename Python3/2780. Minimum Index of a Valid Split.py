class Solution:
    def minimumIndex(self, nums: List[int]) -> int:
        dominant = -1
        count = 0

        for n in nums:
            if count == 0:
                dominant = n
                count += 1
                continue

            if n != dominant:
                count -= 1
            else:
                count += 1

        count = 0
        for n in nums:
            if n == dominant:
                count += 1

        left_count = 0
        N = len(nums)
        for i, n in enumerate(nums):
            if n == dominant:
                left_count += 1

            if left_count > (i + 1) / 2 and (count - left_count) > (N - i - 1) / 2:
                return i

        return -1