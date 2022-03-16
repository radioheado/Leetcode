class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [(0,1), (0,-1), (1,0), (-1,0)]
        self.ans = False
        M, N = len(board), len(board[0])
        
        def backtrack(r, c, cur):
            if cur == len(word):
                self.ans = True
                return
            
            for i, j in directions:
                x, y = r+i, c+j
                if 0<=x<M and 0<=y<N and board[x][y] == word[cur]:
                    board[x][y] = '1'
                    backtrack(x, y, cur+1)
                    board[x][y] = word[cur]
        
        for r in range(M):
            for c in range(N):
                if board[r][c] == word[0]:
                    board[r][c] = '1'
                    backtrack(r, c, 1)
                    board[r][c] = word[0]
                if self.ans:
                    return self.ans
        
        return False