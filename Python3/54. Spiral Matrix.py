class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        result = []
        row, col = len(matrix), len(matrix[0])
        up = left = 0
        down = row - 1
        right = col - 1
        
        # check condition is whether all the elements are added to the result list
        while len(result) < row*col:
            
            # traverse from left to right
            for c in range(left, right+1):
                result.append(matrix[up][c])
                
            # traverse from top to bottom
            for r in range(up+1, down+1):
                result.append(matrix[r][right])
                
            # traverse from right to left
            # NOTE here is "left-1" because we still need to
            # visit the "left"most element 
            if up != down:
                for c in range(right-1, left-1, -1):
                    result.append(matrix[down][c])
                    
            # traverse from bottom to up
            # NOTE here is just "up" instead of "up-1"
            # because we have already visited the "up" level
            if left != right:
                for r in range(down-1, up, -1):
                    result.append(matrix[r][left])
                    
            left += 1
            right -= 1
            up += 1
            down -= 1
            
        return result