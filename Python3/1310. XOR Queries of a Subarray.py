class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        prefix = [0]
        for a in arr:
            prefix.append(prefix[-1] ^ a)

        ans = []
        for s, e in queries:
            ans.append(prefix[e + 1] ^ prefix[s])
        return ans