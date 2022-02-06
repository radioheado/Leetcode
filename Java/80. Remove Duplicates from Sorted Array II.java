class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1, dup = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                dup++;
            }else{
                dup = 1;
            }
            
            if(dup <= 2){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}