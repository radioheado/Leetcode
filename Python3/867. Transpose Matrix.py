class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        ans = []
        
        for c in range(len(matrix[0])):
            temp = []
            for r in range(len(matrix)):
                temp.append(matrix[r][c])
            ans.append(temp)
            
        return ans