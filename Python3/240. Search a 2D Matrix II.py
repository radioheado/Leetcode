class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # edge case: empty matrix
        if not matrix:
            return False
        
        # starts from the bottom-left
        # if cur > target, then any number that resides "down" will not satisfy
        # thus, make row--
        # if cur < target, then any number that resides "left" will not satisfy
        # thus, make col++
        # stop when reaches a boundary
        
        # use this for quicker boundary check
        rows, cols = len(matrix), len(matrix[0])
        
        # start location: bottom-left
        row, col = rows-1, 0
        
        while row >=0 and col < cols:
            if matrix[row][col] > target:
                row -= 1
            elif matrix[row][col] < target:
                col += 1
            else:
                return True
            
        return False