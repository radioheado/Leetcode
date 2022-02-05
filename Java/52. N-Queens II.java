class Solution {
    private int size;
    private int ans = 0;
    
    public int totalNQueens(int n) {
        size = n;
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        
        return ans;
    }
    
    private void backtrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antis){
        // base case
        if(row == size){
            ans++;
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
            
            backtrack(row+1, cols, diagonals, antis);
            
            // reset the parameters
            cols.remove(col);
            diagonals.remove(cur_diag);
            antis.remove(cur_anti);
        }
    }
    
}