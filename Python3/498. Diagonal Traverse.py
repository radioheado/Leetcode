class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        diagonals = collections.defaultdict(list)
        
        m, n = len(mat), len(mat[0])
        # add each element to its corresponding dict key
        # the numbers in the same diagonal share the same value
        # of the sum of their indices
        for i in range(m):
            for j in range(n):
                diagonals[i+j].append(mat[i][j])
                
        result = []
        # if (i+j)%2 == 0, the list should be reversed order
        for i in range(m+n):
            temp = diagonals[i]
            if i%2 == 0:
                temp = temp[::-1]
                
            result.extend(temp)
            
        return result
        