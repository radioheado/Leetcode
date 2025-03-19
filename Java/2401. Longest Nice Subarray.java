class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 1, l = 0, used_bits = 0;
        for (int r = 0; r < nums.length; r++) {
            while ((nums[r] & used_bits) != 0) {
                used_bits ^= nums[l++];
            }
            used_bits |= nums[r];
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}