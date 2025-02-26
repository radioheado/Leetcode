class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_ending = 0, min_ending = 0, ans = 0;

        for (int n: nums) {
            max_ending = Math.max(max_ending + n, n);
            min_ending = Math.min(min_ending + n, n);
            ans = Math.max(ans, Math.max(max_ending, Math.abs(min_ending)));
        }

        return ans;
    }
}