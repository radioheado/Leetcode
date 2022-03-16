class Solution {
    private final static int[][] directions = new int[][] {{0,1}, {0,-1}, {1,-0}, {-1,0}};
    private boolean ans = false;
    private String string;
    
    public boolean exist(char[][] board, String word) {
        string = word;
        int M = board.length;
        int N = board[0].length;
        
        for (int r=0; r<M; r++) {
            for (int c=0; c<N; c++) {
                if (board[r][c] == word.charAt(0)) {
                    board[r][c] = '#';
                    backtrack(board, 1, r, c);
                    board[r][c] = word.charAt(0);
                }
                if (ans) {
                    return ans;
                }
            }
        }
        return false;
    }
    
    private void backtrack(char[][] board, int cur, int r, int c) {
        if (cur == string.length()) {
            ans = true;
            return;
        }
        
        for (int[] d: directions) {
            int x =r+d[0], y = c+d[1];
            if (isValid(board, cur, x, y)) {
                board[x][y] = '#';
                backtrack(board, cur+1, x, y);
                board[x][y] = string.charAt(cur);
            }
        }
    }
    
    private boolean isValid(char[][] board, int cur, int r, int c) {
        int M = board.length;
        int N = board[0].length;
        return ((r >= 0) && (r < M) && (c >= 0) && (c < N) && (board[r][c] == string.charAt(cur)));
    }
}