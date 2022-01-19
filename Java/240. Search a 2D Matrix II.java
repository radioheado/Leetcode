class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        int row = rows-1, col = 0;
        
        while(row >= 0 && col < cols){
            if(matrix[row][col] > target){
                row--;
            }else if(matrix[row][col] < target){
                col++;
            }else{
                return true;
            }
        }
        
        return false;
    }
}