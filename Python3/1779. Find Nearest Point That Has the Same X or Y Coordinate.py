class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        
        minn = inf
        dis = {}
        
        for i, (a, b) in enumerate(points):
            if a == x or b == y:
                d = abs(a-x + b-y)
                if d not in dis:
                    dis[d] = i
                minn = min(minn, d)
        
        return dis[minn] if minn != inf else -1