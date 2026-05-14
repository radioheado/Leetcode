class Solution:
    def isGood(self, nums: List[int]) -> bool:
        n = len(nums) - 1
        count_n = 0
        count = set()

        for num in nums:
            if num < 1 or num > n:
                return False
            elif num < n:
                if num in count:
                    return False
                count.add(num)
            else:
                count_n += 1

        return count_n == 2