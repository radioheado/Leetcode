class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        pairs.sort(key = lambda x: x[1])
        cur = -inf
        ans = 0

        for s, e in pairs:
            if s > cur:
                ans += 1
                cur = e

        return ans