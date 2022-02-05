class Solution {
    public int rob(int[] nums) {
        // edge case
        if(nums.length == 0){
            return 0;
        }
        
        int robNext = nums[nums.length-1], robPlus = 0;
        
        for(int i=nums.length-2; i>=0; i--){
            int cur = Math.max(robNext, robPlus + nums[i]);
            robPlus = robNext;
            robNext = cur;
        }
        
        return robNext;
    }
}