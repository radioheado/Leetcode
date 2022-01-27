class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;
        int left = matrix[0][0], right = matrix[N-1][N-1];
        
        while(left < right){
            int mid = (right-left)/2 + left;
            int[] temp = countLessEqual(matrix, mid, left, right);
            int count = temp[0], smaller = temp[1], larger = temp[2];
            
            if(count == k){
                return smaller;
            }
            else if(count < k){
                left = larger;
            }
            else{
                right = smaller;
            }
        }
        
        return left;
    }
    
    /* a helper function to count how many numbers are in the left half
     * and the largest number that's smaller than mid
     * and the smallest number that's larger than mid
     */
    private int[] countLessEqual(int[][] matrix, int mid, int left, int right){
        int count = 0, N = matrix.length;
        int row = N-1, col = 0;
        
        while(row >= 0 && col < N){
            /* if the last number in this column is larger than mid
             * then look up and start updating the 
             * smallest number that's larger than mid
             */
            if(matrix[row][col] > mid){
                right = Math.min(right, matrix[row--][col]);
            }
            else{
                left = Math.max(left, matrix[row][col++]);
                count += row + 1;
            }
        }
        
        return new int[] {count, left, right};
    }
}