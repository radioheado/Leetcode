class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        s = (1 + n) * n // 2
        ans = [None, None]
        seen = set()
        
        for c in nums:
            if c in seen:
                ans[0] = c
                continue
            s -= c
            seen.add(c)
        
        ans[1] = s
        return ans