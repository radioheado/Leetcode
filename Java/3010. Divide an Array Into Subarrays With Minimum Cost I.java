class Solution {
    public int minimumCost(int[] nums) {
        int first = 51, second = 51;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= first) {
                second = first;
                first = nums[i];
            } else if (nums[i] < second) {
                second = nums[i];
            }
        }
        return nums[0] + first + second;
    }
}