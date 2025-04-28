class Solution {
    public int countSubarrays(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int one = nums[i], two = nums[i + 1], three = nums[i + 2];
            if (2 * (one + three) == two) {
                ans++;
            }
        }
        return ans;
    }
}