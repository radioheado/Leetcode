# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
#class BinaryMatrix(object):
#    def get(self, row: int, col: int) -> int:
#    def dimensions(self) -> list[]:

class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        rows, cols = binaryMatrix.dimensions()
        # top-right corner
        row, col = 0, cols-1
        res = -1
        
        while row < rows and col >= 0:
            # found 1, move left
            if binaryMatrix.get(row, col):
                res = col
                col -= 1
            # found 0, move down
            else:
                row += 1
                
        
        return res