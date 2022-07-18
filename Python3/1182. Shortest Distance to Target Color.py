class Solution:
    def shortestDistanceColor(self, colors: List[int], queries: List[List[int]]) -> List[int]:
        n = len(colors)
        dp = [[-1]*3 for _ in range(n)]
        dp[0][colors[0]-1] = 0
        
        # left to right
        for i in range(1, n):
            for j in range(3):
                # distance to this color is 0
                if colors[i] == j+1:
                    dp[i][j] = 0
                    
                # if this color isn't reachable from the last index,
                # it's not reachable at this step either
                elif dp[i-1][j] == -1:
                    dp[i][j] = -1
                    
                # increment the distance if itself is not this color
                else:
                    dp[i][j] = dp[i-1][j] + 1 
        
        #print(dp)
        # right to left
        for i in range(n-2, -1, -1):
            for j in range(3):
                if dp[i][j] == -1:
                    dp[i][j] = dp[i+1][j]+1 if dp[i+1][j] != -1 else dp[i][j]
                else:
                    dp[i][j] = min(dp[i][j], dp[i+1][j]+1) if dp[i+1][j] != -1 else dp[i][j]
                
        
        #print(dp)
        ans = []
        for i, c in queries:
            dis = dp[i][c-1]
            ans.append(dis)
            
        return ans