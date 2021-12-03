class Solution {
    public int maxSubArray(int[] nums) {
        int curArray = nums[0];
        int maxArray = nums[0];
        
        for(int i=1; i<nums.length; i++){
            curArray = Math.max(curArray+nums[i], nums[i]);
            maxArray = Math.max(curArray, maxArray);
        }
        
        return maxArray;
    }
}