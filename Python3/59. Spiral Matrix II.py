class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        # NOTE: must initialize result list in this way
        #       or the result will be weird
        #       for example, if n = 2, the result should be [[1,2], [4,3]]
        #       but if initialize it by [[None]*n]*n
        #       the result is: [[4,3], [4,3]]
        #       it seems like the nodes are somehow binded
        
        result = [[0 for _ in range(n)] for i in range(n)]
        up = left = 0
        down = n - 1
        right = n - 1
        
        num = 1
        
        # check condition is whether all the elements are added to the result list
        while num <= n*n:
            #print(result)
            # traverse from left to right
            for c in range(left, right+1):
                #print("result[%d][%d] = %d" %(up, c, num))
                result[up][c] = num
                num += 1
            #print(result)    
            # traverse from top to bottom
            for r in range(up+1, down+1):
                #print("result[%d][%d] = %d" %(r, right, num))
                result[r][right] = num
                num += 1
            #print(result)    
            # traverse from right to left
            # NOTE here is "left-1" because we still need to
            # visit the "left"most element 
            if up != down:
                for c in range(right-1, left-1, -1):
                    #print("result[%d][%d] = %d" %(down, c, num))
                    result[down][c] = num
                    num += 1
                    
            # traverse from bottom to up
            # NOTE here is just "up" instead of "up-1"
            # because we have already visited the "up" level
            if left != right:
                for r in range(down-1, up, -1):
                    #print("result[%d][%d] = %d" %(r, left, num))
                    result[r][left] = num
                    num += 1
                    
            left += 1
            right -= 1
            up += 1
            down -= 1
            #print(result)
        
        #print(result)
        return result