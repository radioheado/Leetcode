class Solution {
    public boolean isTrionic(int[] nums) {
        if (nums[0] >= nums[1]) {
            return false;
        }
        
        int count = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }

            if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
                count++;
            }
        }
        return count == 3;
    }
}