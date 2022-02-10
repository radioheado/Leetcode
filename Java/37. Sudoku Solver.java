class Solution {
    private HashSet<Character>[] rows = new HashSet[9];
    private HashSet<Character>[] cols = new HashSet[9];
    private HashSet<Character>[] boxs = new HashSet[9];
    
    public void solveSudoku(char[][] board) {
        
        for (int r = 0; r < 9; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxs[r] = new HashSet<Character>();
        }
        
        // add all existing numbers to the sets
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                if(board[r][c] != '.'){
                    rows[r].add(board[r][c]);
                    cols[c].add(board[r][c]);
                    boxs[(r/3)*3 + c/3].add(board[r][c]);
                }
            }
        }
        
        backtrack(board, 0, 0);
        
    }
    
    private boolean backtrack(char[][] board, int r, int c) {
        if(r == 8 && c == 9){
            return true;
        }else if(c == 9){
            c = 0;
            r++;
        }
        
        if(board[r][c] != '.'){
            return backtrack(board, r, c+1);
        }else{
            int b = (r/3)*3+c/3;
            
            for(int n=1; n<=9; n++){
                Character cur = (char)('0' + n);
                if(!rows[r].contains(cur) && !cols[c].contains(cur) && !boxs[b].contains(cur)){
                    board[r][c] = cur;
                    rows[r].add(cur);
                    cols[c].add(cur);
                    boxs[b].add(cur);
                    
                    if(backtrack(board, r, c+1)){
                        return true;
                    }
                    
                    board[r][c] = '.';
                    rows[r].remove(cur);
                    cols[c].remove(cur);
                    boxs[b].remove(cur);
                }
            }
        }
        
        return false;
    }
}