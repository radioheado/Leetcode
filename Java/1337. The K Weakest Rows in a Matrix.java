class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int ROWS = mat.length;
        int COLS = mat[0].length;
        
        int[] res = new int[k];
        int count = 0;
        
        for(int c=0; c<COLS; c++){
            for(int r=0; r<ROWS; r++){
                /* only add r to the result list if
                 * its left is 1 or itself is the 0-th column
                 */
                if(mat[r][c] == 0 && (c == 0 || mat[r][c-1] == 1) && count < k){
                    res[count++] = r;
                }
            }
        }
        
        /* if there's not enough rows were added
         * add from the start to see which row has the last element as 1
         */
        int r = 0;
        while(count < k){
            if(mat[r][COLS-1] == 1){
                res[count++] = r;
            }
            r++;
        }
        
        return res;
    }
}