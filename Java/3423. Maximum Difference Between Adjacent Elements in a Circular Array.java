class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, Math.abs(nums[i] - nums[i-1]));
        }
        return Math.max(ans, Math.abs(nums[nums.length-1] - nums[0]));
    }
}