class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length < 3)    return true;
        
        int up = 0, down = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i-1])    up = 1;
            else if (nums[i] < nums[i-1])   down = 1;
            
            if (up + down > 1)  return false;
        }
        
        return true;
    }
}