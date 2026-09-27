class Solution:
    def smallestIndex(self, nums: List[int]) -> int:
        for i, n in enumerate(nums):
            _sum = 0
            while n:
                _sum += n % 10
                if _sum > i:
                    break
                n //= 10

            if _sum == i:
                return i

        return -1
