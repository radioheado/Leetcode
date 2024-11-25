class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int min_abs = 100001, neg = 0;

        for (int[] row: matrix) {
            for (int num: row) {
                ans += Math.abs(num);
                if (num < 0) {
                    neg = (neg + 1) % 2;
                }
                min_abs = Math.min(min_abs, Math.abs(num));
            }
        }

        if (neg == 1) {
            ans -= 2 * min_abs;
        }

        return ans;
    }
}