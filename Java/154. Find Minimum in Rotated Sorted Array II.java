class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while (left < right){
            /* prevent integer overflow */
            int mid = (right-left)/2+left;
            
            /* Case 1: n[mid] < n[right], the pivot resides to the left half
             *         note n[mid] is also possible for being the pivot
             */
            if (nums[mid] < nums[right]){
                right = mid;
            }
               
            /* Case 2: n[mid] > n[left], the pivot resides to the right half
             *        in this case, n[mid] cannot be the pivot
             */
            else if (nums[mid] > nums[right]){
                left = mid+1;
            }
                
            /* Case 3: n[mid] == n[right], we are not sure which half the pivot resides in
             *         so it's safe to move upper bound by one
             */
            else{
                right--;
            } 
        }
                
        return nums[right];
    }
}