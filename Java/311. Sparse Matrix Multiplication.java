class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        Map<Integer, Set<Integer>> A = new HashMap();

        int m = mat1.length, k = mat1[0].length, n = mat2[0].length;
        for (int r=0; r<m; r++) {
            for (int c=0; c<k; c++) {
                A.computeIfAbsent(r, value -> new HashSet()).add(c);
            }
        }

        int[][] ans = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int cur = 0;
                if (A.containsKey(row)) {
                    for (int c: A.get(row)) {
                        cur += mat1[row][c] * mat2[c][col];
                    }
                }
                ans[row][col] = cur;
            }
        }

        return ans;
    }
}