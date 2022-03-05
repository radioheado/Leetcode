class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] sim = new double[query_row+3][query_row+3];
        sim[0][0] = (double) poured;
        
        for(int r=0; r<query_row+1; r++) {
            for(int c=0; c<r+1; c++) {
                double flow = (sim[r][c] - 1.0) / 2.0;
                if(flow > 0) {
                    sim[r+1][c] += flow;
                    sim[r+1][c+1] += flow;
                }
            }
        }
        
        return Math.min(1, sim[query_row][query_glass]);
    }
}