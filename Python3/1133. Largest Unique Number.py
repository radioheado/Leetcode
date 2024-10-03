class Solution:
    def largestUniqueNumber(self, nums: List[int]) -> int:
        bucket = [0] * 1001
        for n in nums:
            bucket[n] += 1

        for i in range(1000, -1, -1):
            if bucket[i] == 1:
                return i

        return -1