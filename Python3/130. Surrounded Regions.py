class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.M = len(board)
        self.N = len(board[0])
        borders = list(product(range(self.M), [0, self.N-1])) + \
                  list(product([0, self.M-1], range(self.N)))
        
        # pick escaped nodes
        for row, col in borders:
                self.dfs(board, row, col)
        
        # flip the escaped nodes back to 'O' and the inner 'O's to 'X'
        for r in range(self.M):
            for c in range(self.N):
                if board[r][c] == 'E':
                    board[r][c] = 'O'
                elif board[r][c] == 'O':
                    board[r][c] = 'X'
    
    # one-pass dfs to mark all escaped nodes
    def dfs(self, board, x, y):
        if board[x][y] != 'O':
            return
            
        # mark this node as 'Escaped'
        board[x][y] = 'E'
        if y < self.N-1: self.dfs(board, x, y+1)
        if x < self.M-1: self.dfs(board, x+1, y)
        if y > 0: self.dfs(board, x, y-1)
        if x > 0: self.dfs(board, x-1, y)