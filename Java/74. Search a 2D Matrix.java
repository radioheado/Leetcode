class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target);
        
        if (row == -1){
            return false;
        }
        
        int col = searchCol(matrix, target, row);
        return col == -1 ? false : true;
    }
    
    private int searchRow(int[][] matrix, int target){
        int left = 0, right = matrix.length-1;
        
        while (left <= right){
            int mid = (right-left)/2 + left;
            
            //System.out.println(mid);
            // target resides in this row
            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length-1]){
                
                return mid;
            }   
            else if (matrix[mid][0] > target)
                right = mid-1;
                    
            else
                left = mid+1;
        }
        
        return -1;
    }
    
    private int searchCol(int[][] matrix, int target, int row){
        int left = 0, right = matrix[0].length-1;
        
        while (left <= right){
            int mid = (right-left)/2 + left;
            
            if (matrix[row][mid] == target)
                return mid;
                
            else if (matrix[row][mid] > target)
                right = mid-1;
                
            else
                left = mid+1;
        }
        
        return -1;
    }
}