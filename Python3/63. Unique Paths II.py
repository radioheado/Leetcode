class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        if obstacleGrid[0][0]:  return 0
        
        obstacleGrid[0][0] = 1
        
        for i in range(1, n):
            if obstacleGrid[0][i]:
                obstacleGrid[0][i] = 0
            else:
                obstacleGrid[0][i] = obstacleGrid[0][i-1]
                
        #print(obstacleGrid)
        
        for j in range(1, m):
            if obstacleGrid[j][0]:
                obstacleGrid[j][0] = 0
            else:
                obstacleGrid[j][0] = obstacleGrid[j-1][0]
                
        #print(obstacleGrid)
                
        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j]:
                    obstacleGrid[i][j] = 0
                else:
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]
                    
        return obstacleGrid[m-1][n-1]