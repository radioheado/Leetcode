class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        if len(points) == 1:
            return 1
        
        ans = 0
        
        for i in range(len(points)):
            lines = collections.defaultdict(int)
            for j in range(i+1, len(points)):
                slope = self.getSlope(points[i], points[j])
                lines[slope] = lines.get(slope, 1) + 1
                ans = max(ans, lines[slope])
                #print(slope)
        return ans
        
        
    def getSlope(self, p1, p2):
        # use co-prime instead of float/double
        x, y = p1[0] - p2[0], p1[1] - p2[1]
        
        # vertical line
        if x == 0:
            return (0, 0)
        
        # horizontal line
        elif y == 0:
            return (sys.maxsize, sys.maxsize)
        
        # make x positive to keep consistent
        elif x < 0:
            x, y = -x, -y
        
        gcd = math.gcd(x, y)
        return (x//gcd, y//gcd)