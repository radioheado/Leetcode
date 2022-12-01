class TicTacToe {
    private int[] rows, cols;
    private int ldiagonal, rdiagonal, N;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        N = n;
    }
    
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        rows[row] += val;
        cols[col] += val;
        
        if (row == col) {
            ldiagonal += val;
        }
        if (row + col == N - 1) {
            rdiagonal += val;
        }
        
        if (Math.abs(rows[row]) == N || Math.abs(cols[col]) == N || Math.abs(ldiagonal) == N || Math.abs(rdiagonal) == N) {
            return player;
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */