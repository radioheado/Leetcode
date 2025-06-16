class Solution {
    public int maximumDifference(int[] nums) {
        int min_num = Integer.MAX_VALUE, max_diff = -1;
        for (int n: nums) {
            if (n > min_num) {
                max_diff = Math.max(max_diff, n - min_num);
            }
            min_num = Math.min(min_num, n);
        }
        return max_diff;
    }
}