class Solution {
    public int maxProduct(int[] nums) {
        int maxsofar = nums[0];
        int minsofar = maxsofar;
        int result = maxsofar;
        
        for(int i=1; i<nums.length; i++){
            int temp_max = Math.max(nums[i], Math.max(maxsofar*nums[i], minsofar*nums[i]));
            minsofar = Math.min(nums[i], Math.min(maxsofar*nums[i], minsofar*nums[i]));
            maxsofar = temp_max;
            
            result = Math.max(result, maxsofar);
        }
        
        return result;
    }
}