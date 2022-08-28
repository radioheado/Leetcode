class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int R = mat.length, C = mat[0].length;
        Map<Integer, Queue<Integer>> diagonals = new HashMap();
        
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                diagonals.putIfAbsent(r-c, new PriorityQueue());
                diagonals.get(r-c).add(mat[r][c]);
            }
        }
        
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                mat[r][c] = diagonals.get(r-c).remove();
            }
        }
        
        return mat;
    }
}