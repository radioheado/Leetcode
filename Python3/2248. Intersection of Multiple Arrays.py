class Solution:
    def intersection(self, nums: List[List[int]]) -> List[int]:
        count = [0] * 1001
        for num in nums:
            for n in num:
                count[n] += 1

        N = len(nums)
        ans = []

        for i, n in enumerate(count):
            if n == N:
                ans.append(i)

        return ans