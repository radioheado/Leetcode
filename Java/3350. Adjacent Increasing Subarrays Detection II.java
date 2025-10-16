class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int streak = 1, left = 0, ans = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                streak++;
            } else {
                left = streak;
                streak = 1;
            }
            ans = Math.max(ans, Math.min(left, streak));
            ans = Math.max(ans, streak / 2);
        }

        return ans;
    }
}