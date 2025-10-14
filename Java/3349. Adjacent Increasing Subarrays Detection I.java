class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int left = 0, streak = 1;
        for (int i = 1; i < nums.size(); i++){
            if (nums.get(i) > nums.get(i - 1)) {
                streak++;
            } else {
                left = streak;
                streak = 1;
            }

            if ((streak >= 2 * k) || (streak >= k && left >= k)) {
                return true;
            }
        }

        return false;
    }
}