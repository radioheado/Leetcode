class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = nums[nums.length - 1] - nums[0];
        for (int r = 0; r < nums.length; r++) {
            if (r - k + 1 >= 0) {
                minDiff = Math.min(minDiff, nums[r] - nums[r - k + 1]);
            }
        }
        return minDiff;
    }
}