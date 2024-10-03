class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        n = len(edges)
        degrees = [0] * (n + 2)

        for u, v in edges:
            degrees[u] += 1
            degrees[v] += 1
            if degrees[u] > 1:
                return u
            if degrees[v] > 1:
                return v