class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int N = mat.length, M = mat[0].length, i = 0;
        int[] ans = new int[N * M];
        List<Integer> temp = new ArrayList<>();

        for (int d = 0; d < N + M - 1; d++) {
            temp.clear();
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            while (r < N && c > -1) {
                temp.add(mat[r][c]);
                r++;
                c--;
            }

            if (d % 2 == 0) {
                Collections.reverse(temp);
            }

            for (int p = 0; p < temp.size(); p++) {
                ans[i++] = temp.get(p);
            }
        }

        return ans;
    }
}