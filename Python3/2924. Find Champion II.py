class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        degrees = [0] * n

        for u, v in edges:
            degrees[v] += 1

        ans = -1
        for node, degree in enumerate(degrees):
            if degree == 0:
                if ans == -1:
                    ans = node
                else:
                    return -1

        return ans