class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[] {-1, -1};
        }
        
        int start = searchStart(nums, target);
        int end = searchEnd(nums, target);
        
        if(start < nums.length && start <= end){
            return new int[] {start, end};
        }else{
            return new int[] {-1, -1};
        }
    }
    
    private int searchStart(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (right-left)/2 + left;
            if(nums[mid] >= target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    
    private int searchEnd(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (right-left)/2 + left;
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}