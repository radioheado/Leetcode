class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int status;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                status = checkNeis(board, r, c);
                //System.out.println("row = " + r + " col = " + c + " status = " + status);
                if (board[r][c] == 1) {
                    /* over-population or under-population */
                    if (status > 3 || status < 2) {
                        board[r][c] = -1;
                    } 
                } else {
                    /* reproduction */
                    if (status == 3) {
                        board[r][c] = 2;
                    }
                }
            }
        }
        
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (board[r][c] > 0) {
                    board[r][c] = 1;
                } else {
                    board[r][c] = 0;
                }
            }
        }
    }
    
    private int checkNeis(int[][] board, int row, int col) {
        int rows = board.length, cols = board[0].length;
        int alive = 0;
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                if (!(i == 0 && j == 0)) {
                    int x = row + i, y = col + j;
                    /* if the neighbor is valid, check its value */
                    if (0 <= x && x < rows && 0 <= y && y <cols && Math.abs(board[x][y]) == 1) {
                        alive++;
                    }
                }
            }
        }
        return alive;
    }
}