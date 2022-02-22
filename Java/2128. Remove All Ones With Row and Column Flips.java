class Solution {
    public boolean removeOnes(int[][] grid) {
        int[] first = grid[0];
        int[] rev = reverse(first);
        
        for(int[] row: grid) {
            if(!Arrays.equals(row, first) && !Arrays.equals(row, rev)) {
                return false;
            }
        }
        
        return true;
    }
    
    private int[] reverse(int[] row) {
        int[] ans = new int[row.length];
        int i = 0;
        
        for(int n: row) {
            ans[i++] = n^1;
            //System.out.println(ans[i-1]);
        }
        return ans;
    }
    
}