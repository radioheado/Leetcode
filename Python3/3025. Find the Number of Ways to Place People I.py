class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        points.sort(key=lambda x: (x[0], -x[1]))
        ans = 0
        N = len(points)

        for i in range(N - 1):
            high = points[i][1]
            low = -inf
            for j in range(i + 1, N):
                cur = points[j][1]
                if cur > high:
                    continue

                if cur > low:
                    ans += 1
                    low = cur

        return ans