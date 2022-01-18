/* One-pass */
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        
        while(start <= end){
            int mid = (end-start)/2+start;
            
            // found the target
            if(nums[mid] == target){
                return mid;
            }
            
            // start to mid is non-rotated
            else if(nums[mid] >= nums[start]){
                // if target falls into start to mid
                if(nums[start] <= target && target < nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                /* mid to end is non-rotated
                 * if target falls into this area, update start
                 * otherwise, update end
                 */
                if(nums[mid] < target && target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        
        return -1;
    }
}