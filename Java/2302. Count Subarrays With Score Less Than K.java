class Solution {
    public long countSubarrays(int[] nums, long k) {
        int l = 0;
        long ans = 0, prefix = 0;
        for (int r = 0; r < nums.length; r++) {
            prefix += nums[r];
            while (l <= r && prefix * (r - l + 1) >= k) {
                prefix -= nums[l++];
            }
            ans += r - l + 1;
        }

        return ans;
    }
}