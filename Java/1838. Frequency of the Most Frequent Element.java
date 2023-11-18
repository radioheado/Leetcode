class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, l = 0, used = 0;

        for (int r = 1; r < nums.length; r++) {
            used += (r - l) * (nums[r] - nums[r - 1]);
            while (used > k) {
                used -= nums[r] - nums[l++];
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}