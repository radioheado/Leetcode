class Solution {
    public int minStartValue(int[] nums) {
        
        int m = nums[0];
        int last = nums[0];
        
        for(int i=1; i<nums.length; i++){
            
            m = Math.min(m, last+nums[i]);
            last += nums[i];
            
        }
        
        return(m<0 ? 1-m : 1);
    }
}