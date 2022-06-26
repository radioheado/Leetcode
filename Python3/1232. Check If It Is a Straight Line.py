class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        N = len(coordinates)
        # special case: two points make a line
        if N == 2:
            return True
        
        b = coordinates[1][1] - coordinates[0][1]
        a = coordinates[1][0] - coordinates[0][0]
        
        for i in range(1, N-1):
            y = coordinates[i+1][1] - coordinates[i][1]
            x = coordinates[i+1][0] - coordinates[i][0]
            if b*x != a*y:
                return False
            
        return True