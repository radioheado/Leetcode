class Solution {
    private int size;
    private List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char[][] emptyBoard = new char[size][size];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                emptyBoard[i][j] = '.';
            }
        }
        
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return ans;
    }
    
    private void backtrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antis, char[][] state){
        // base case
        if(row == size){
            ans.add(formatter(state));
            return;
        }
        
        for(int col=0; col<size; col++){
            int cur_diag = row-col;
            int cur_anti = row+col;
            
            // if the queen is not placeable
            if(cols.contains(col) || diagonals.contains(cur_diag) || antis.contains(cur_anti)){
                continue;
            }
            
            // place the queen
            cols.add(col);
            diagonals.add(cur_diag);
            antis.add(cur_anti);
            state[row][col] = 'Q';
            
            backtrack(row+1, cols, diagonals, antis, state);
            
            // reset the parameters
            cols.remove(col);
            diagonals.remove(cur_diag);
            antis.remove(cur_anti);
            state[row][col] = '.';
        }
    }
    
    private List<String> formatter(char[][] state){
        List<String> board = new ArrayList<>();
        for(int row=0; row<size; row++){
            String cur = new String(state[row]);
            board.add(cur);
        }
        return board;
    }
}