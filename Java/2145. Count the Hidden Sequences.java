class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int max_diff = 0, min_diff = 0, cur = 0;
        for (int d: differences) {
            cur += d;
            max_diff = Math.max(max_diff, cur);
            min_diff = Math.min(min_diff, cur);
            if (max_diff - min_diff > upper - lower) {
                return 0;
            }
        }
        return upper - lower - max_diff + min_diff + 1;
    }
}