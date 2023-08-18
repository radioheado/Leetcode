class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        degrees = [0] * n
        ans = 0
        existed = set()

        for u, v in roads:
            degrees[u] += 1
            degrees[v] += 1
            existed.add((min(u, v), max(u, v)))

        for u in range(n-1):
            for v in range(u+1, n):
                if (u, v) in existed:
                    ans = max(ans, degrees[u] + degrees[v] - 1)
                else:
                    ans = max(ans, degrees[u] + degrees[v])

        return ans