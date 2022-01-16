class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows 
        for(char[] rows: board){
            if(!isValid(rows)){
                return false;
            }
        }
        
        // check columns
        for(int j=0; j<9; j++){
            char[] cols = new char[9];
            int idx = 0;
            
            for(int i=0; i<9; i++){
                cols[idx++] = board[i][j];
            }
            
            if(!isValid(cols)){
                return false;
            }
        }
        
        // check sub-boxes
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                if(!validBox(i, j, board)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[] nums){
        Set<Character> seen = new HashSet<>();
        for(char n: nums){
            if(n == '.'){
                continue;
            }
            if(seen.contains(n)){
                return false;
            }
            seen.add(n);
        }
        return true;
    }
    
    private boolean validBox(int i, int j, char[][] board){
        char[] nums = new char[9];
        int idx = 0;
        
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                nums[idx++] = board[row+i][col+j];
            }
        }
        
        return isValid(nums);
    }
}