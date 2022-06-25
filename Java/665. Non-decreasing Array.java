class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean flag = true;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (!flag) {
                    return false;
                }
                flag = false;
                if (i < 1 || nums[i+1] >= nums[i-1]) {
                    nums[i] = nums[i+1];
                } else {
                    nums[i+1] = nums[i];
                }
            }
        }
        
        return true;
    }
}