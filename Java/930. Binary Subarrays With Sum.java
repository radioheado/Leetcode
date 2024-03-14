class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int l = 0, psum = 0, ans = 0, zeros = 0;
        for (int r = 0; r < nums.length; r++) {
            psum += nums[r];

            while (l < r && (nums[l] == 0 || psum > goal)) {
                if (nums[l] == 1) {
                    zeros = 0;
                } else {
                    zeros++;
                }
                psum -= nums[l++];
            }

            if (psum == goal) {
                ans += 1 + zeros;
            }
        }

        return ans;
    }
}