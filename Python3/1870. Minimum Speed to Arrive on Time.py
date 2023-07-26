class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        n = len(dist)
        if n > ceil(hour):
            return -1
        
        def feasible(speed: int) -> bool:
            ans = 0
            for d in dist[:-1]:
                ans += ceil(d / speed)
            
            ans += dist[-1] / speed
            return ans <= hour

        l, r = 1, ceil(max(dist) / (hour - floor(hour))) if hour != floor(hour) else max(dist)
        while l < r:
            m = (r - l) // 2 + l
            if feasible(m):
                r = m
            else:
                l = m + 1
        return l