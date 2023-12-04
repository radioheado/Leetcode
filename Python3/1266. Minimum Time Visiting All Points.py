class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        if len(points) == 1:
            return 0

        ans = 0
        px, py = points[0]

        for cx, cy in points[1:]:
            ans += max(abs(cx - px), abs(cy - py))
            px, py = cx, cy

        return ans