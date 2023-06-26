class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        record = collections.defaultdict(int)
        ans = 2
        
        for i, n in enumerate(nums[1:], 1):
            for j in range(i):
                left = nums[j]
                diff = n - left
                record[(i, diff)] = record.get((j, diff), 1) + 1
                ans = max(ans, record[(i, diff)])

        return ans