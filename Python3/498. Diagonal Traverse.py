class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        n, m = len(mat), len(mat[0])
        ans = []
        turn = False

        for i in range(m + n - 1):
            temp = []
            r = 0 if i < m else i - m + 1
            c = i if i < m else m - 1

            while r < n and c > -1:
                temp.append(mat[r][c])
                r += 1
                c -= 1
            
            if turn:
                ans.extend(temp)
            else:
                ans.extend(temp[::-1])
            
            turn = not turn

        return ans