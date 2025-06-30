class Solution:
    def findLHS(self, nums: List[int]) -> int:
        count = Counter(nums)
        ans = 0

        for key, val in count.items():
            if key - 1 in count:
                ans = max(ans, val + count[key - 1])
            
            if key + 1 in count:
                ans = max(ans, val + count[key + 1])

        return ans