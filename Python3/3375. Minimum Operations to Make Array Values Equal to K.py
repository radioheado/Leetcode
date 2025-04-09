class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        count = set()
        for n in nums:
            if n < k:
                return -1
            elif n > k:
                count.add(n)

        return len(count)