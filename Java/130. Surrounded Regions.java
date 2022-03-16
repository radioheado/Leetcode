class Solution {
    int ROWS;
    int COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        List<int[]> borders = new ArrayList<>();
        
        /* get all border coordinates */
        for (int r=0; r<ROWS; r++) {
            borders.add(new int[] {r, 0});
            borders.add(new int[] {r, COLS-1});
        }
        for (int c=0; c<COLS; c++) {
            borders.add(new int[] {0, c});
            borders.add(new int[] {ROWS-1, c});
        }
        
        /* mark the escaped nodes */
        for (int[] b: borders) {
            //System.out.println("borders");
            this.dfs(board, b[0], b[1]);
        }
        
        /* flip the nodes */
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (board[r][c] == 'E') {
                    board[r][c] = 'O';
                }
                else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
        
    }
    
    /* one-pass dfs to mark border connected nodes as escaped */
    private void dfs(char[][] board, int r, int c) {
        //System.out.println(board[r][c]);
        if (board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'E';
        if (c < COLS-1) this.dfs(board, r, c+1);
        if (r < ROWS-1) this.dfs(board, r+1, c);
        if (c > 0) this.dfs(board, r, c-1);
        if (r > 0) this.dfs(board, r-1, c);
    }
}