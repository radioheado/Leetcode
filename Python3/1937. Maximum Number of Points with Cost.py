class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        #print(dp)
        n = len(points[0])
        res = max(points[0])
        
        for r in range(1, len(points)):
            dp = points[r-1]
            
            for c in range(1, n):
                dp[c] = max(dp[c], dp[c-1]-1)
                
            for c in range(n-2, -1, -1):
                dp[c] = max(dp[c], dp[c+1]-1)
                
            for c in range(n):
                points[r][c] += dp[c]
                res = max(res, points[r][c])
        
        return res
            
                