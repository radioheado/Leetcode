class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        rows, cols = len(grid), len(grid[0])
        ans = [-1] * cols
        
        for col in range(cols):
            c = col
            
            for r in range(rows):
                nextc = c + grid[r][c]
                if nextc < 0 or nextc > cols - 1 or grid[r][c] != grid[r][nextc]:
                    ans[col] = -1
                    break
                    
                ans[col] = nextc
                c = nextc
                
        return ans   