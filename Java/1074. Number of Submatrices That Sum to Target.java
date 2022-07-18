class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int R = matrix.length, C = matrix[0].length;
        
        int[][] sums = new int[R+1][C+1];
        for (int r=1; r<R+1; r++) {
            for (int c=1; c<C+1; c++) {
                sums[r][c] = sums[r][c-1] + sums[r-1][c] - sums[r-1][c-1] + matrix[r-1][c-1];
            }
        }
        
        int count = 0, cur;
        Map<Integer, Integer> m = new HashMap();
        for (int r1=1; r1<=R; ++r1) {
            for (int r2=r1; r2<=R; ++r2) {
                m.clear();
                m.put(0, 1);
                
                for (int c=1; c<=C; ++c) {
                    cur = sums[r2][c] - sums[r1-1][c];
                    count += m.getOrDefault(cur-target, 0);
                    m.put(cur, m.getOrDefault(cur, 0)+1);
                }
            }
        }
        
        return count;
    }
}