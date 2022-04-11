class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        k %= rows*cols;
        List<List<Integer>> res = new ArrayList<>();
        
        int[][] ans = new int[rows][cols];
        int rdiff = k/cols, cdiff = k%cols;
        int x, y;
        
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                y = (j+cdiff) % cols;
                x = (i + rdiff + (j + cdiff)/cols) % rows;
                ans[x][y] = grid[i][j];
            }
        }
        
        for (int[] row: ans) {
            List<Integer> r = new ArrayList<>();
            for (int v: row) {
                r.add(v);
            }
            res.add(r);
        }
        
        return res;
    }
}