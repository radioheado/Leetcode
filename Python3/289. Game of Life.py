class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows, cols = len(board), len(board[0])
        ans = [[board[r][c] for c in range(cols)] for r in range(rows)]
        
        for i in range(rows):
            for j in range(cols):
                board[i][j] = self.checkNei(ans, i, j)
        
        
    def checkNei(self, board, row, col):
        rows, cols = len(board), len(board[0])
        neis = [(0,1), (0,-1), (1,0), (-1,0), (-1,1), (-1,-1), (1,-1), (1,1)]
        live = 0
        for i, j in neis:
            x, y = row+i, col+j
            if 0 <= x < rows and 0 <= y < cols:
                if board[x][y] == 1:
                    live += 1
        
        if board[row][col] == 0:
            if live == 3:
                return 1
            else:
                return 0
            
        if live > 3:
            return 0
        elif live > 1:
            return 1
        else:
            return 0
        
        
        
    
    