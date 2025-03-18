class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long sum = 0, sqr_sum = 0;
        long n = grid.length * grid.length;

        for (int[] row: grid) {
            for (int num: row) {
                sum += num;
                sqr_sum += num * num;
            }
        }

        long sum_diff = sum - (n * (n + 1)) / 2;
        long sqr_diff = sqr_sum - (n * (n + 1) * (2 * n + 1)) / 6;

        int repeat = (int) (sqr_diff / sum_diff + sum_diff) / 2;
        int missing = (int) (sqr_diff / sum_diff - sum_diff) / 2;

        return new int[]{repeat, missing};
    }
}