class Solution:
    def count(self, n):
        return (n*(n+1)) // 2;
    
    def candy(self, ratings: List[int]) -> int:
        candies = old = up = down = 0
        
        for i, r in enumerate(ratings[1:], 1):
            if ratings[i-1] > r:
                new = -1
            elif ratings[i-1] < r:
                new = 1
            else:
                new = 0
            # reach a peak or a valley    
            if (old > 0 and new == 0) or (old < 0 and new >= 0):
                candies += self.count(up) + self.count(down) + max(up, down)
                up = down = 0
            
            if new > 0:
                up += 1
            elif new < 0:
                down += 1
            else:
                candies += 1
            old = new
            
        candies += self.count(up) + self.count(down) + max(up, down) + 1
        return candies