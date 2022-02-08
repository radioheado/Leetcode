class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int local_max = nums[0], global_max = nums[0];
        int local_min = nums[0], global_min = nums[0];
        int sum = nums[0];
        
        for(int i=1; i<nums.length; i++){
            sum += nums[i];
            local_max = Math.max(local_max+nums[i], nums[i]);
            local_min = Math.min(local_min+nums[i], nums[i]);
            global_max = Math.max(global_max, local_max);
            global_min = Math.min(global_min, local_min);
        }
        // edge case: all nums are negative
        if(sum == global_min){
            return global_max;
        }else{
            return Math.max(global_max, sum-global_min);
        }
    }
}