class TicTacToe:

    def __init__(self, n: int):
        self.rows = [0] * n
        self.cols = [0] * n
        self.ldiagonal = 0
        self.rdiagonal = 0
        self.n = n

    def move(self, row: int, col: int, player: int) -> int:
        val = 1 if player == 1 else -1
        
        self.rows[row] += val
        self.cols[col] += val
            
        # check diagonals
        if row == col:
            self.ldiagonal += val
            
        if row + col == self.n - 1:
            self.rdiagonal += val
        
        if abs(self.rows[row]) == self.n or abs(self.cols[col]) == self.n or abs(self.ldiagonal) == self.n or abs(self.rdiagonal) == self.n:
            return player
        
        return 0


# Your TicTacToe object will be instantiated and called as such:
# obj = TicTacToe(n)
# param_1 = obj.move(row,col,player)