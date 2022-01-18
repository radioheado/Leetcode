class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        
        if(nums[left] < nums[right] || right == 0){
            return nums[0];
        }
        
        while(left <= right){
            int mid = (right-left)/2 + left;
            
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }else{
                
                if(nums[mid] < nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        
        return 0;
    }
}