class Solution:
    
    # first search for the row that target is at
    def searchRow(self, matrix, target) -> int:
        left, right = 0, len(matrix)-1
        
        while left <= right:
            mid = (right-left)//2 + left
            
            # target resides in this row
            if(matrix[mid][0] <= target <= matrix[mid][-1]):
                return mid
                
            elif matrix[mid][0] > target:
                right = mid-1
                    
            else:
                left = mid+1
                    
        return -1
    
    # with the row number, search for the column    
    def searchCol(self, matrix, target, row) -> int:
        left, right = 0, len(matrix[0])-1
            
        while left <= right:
            mid = (right-left)//2 + left
                
            if matrix[row][mid] == target:
                return mid
                
            elif matrix[row][mid] > target:
                right = mid-1
                
            else:
                left = mid+1
                    
        return -1
        
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        # calculate row
        row = self.searchRow(matrix, target)
        
        if row == -1:
            return False
        
        # calculate col
        col = self.searchCol(matrix, target, row)
        
        return col != -1