class Solution {
    public long maximumTripletValue(int[] nums) {
        long max_i = 0, max_diff = 0, ans = 0;
        for (int num: nums) {
            ans = Math.max(ans, max_diff * num);
            max_diff = Math.max(max_diff, max_i - num);
            max_i = Math.max(max_i, num);
        }
        return ans;
    }
}