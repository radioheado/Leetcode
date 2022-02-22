class Solution:
    def removeOnes(self, grid: List[List[int]]) -> bool:
        first = grid[0]
        rev = self.reverse(first)
           
        for row in grid[1:]:
            if row != first and row != rev:
                return False
            
        return True
            
    
    def reverse(self, row):
        ans = []
        for n in row:
            ans.append(n^1)
        return ans