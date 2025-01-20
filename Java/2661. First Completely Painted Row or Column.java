class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[] row_count = new int[rows], col_count = new int[cols];
        
        Map<Integer, int[]> positions = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                positions.put(mat[r][c], new int[]{r, c});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int[] pos = positions.get(arr[i]);
            row_count[pos[0]]++;
            col_count[pos[1]]++;
            if (row_count[pos[0]] == cols || col_count[pos[1]] == rows) {
                return i;
            }
        }

        return -1;
    }
}