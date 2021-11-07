class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        
        int cur = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            
            nums[cur] = nums[i];
            cur++;
        }
        
        nums[cur] = nums[nums.length-1];
        
        return cur+1;
    }
}