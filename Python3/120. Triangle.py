class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        for row in range(1, len(triangle)):
            #print(triangle[row])
            for col in range(len(triangle[row])):
                left = col-1 if col >= 1 else 0
                right = col if col <len(triangle[row-1]) else len(triangle[row-1])-1
                #print(left, right)
                triangle[row][col] += min(triangle[row-1][left], triangle[row-1][right])
            #print(triangle[row])
                
        return min(triangle[-1])