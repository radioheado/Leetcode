class Solution:
    def multiply(self, mat1: List[List[int]], mat2: List[List[int]]) -> List[List[int]]:
        A = collections.defaultdict(set)

        m, k, n = len(mat1), len(mat1[0]), len(mat2[0])

        for r in range(m):
            for c in range(k):
                if mat1[r][c] != 0:
                    A[r].add(c)

        ans = [[0] * n for _ in range(m)]
        for row in range(m):
            for col in range(n):
                cur = 0
                for c in A[row]:
                    cur += mat1[row][c] * mat2[c][col]
                ans[row][col] = cur

        return ans