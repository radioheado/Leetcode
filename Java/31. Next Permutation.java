class Solution {
    public void nextPermutation(int[] nums) {
        
        // start reversely reading elements from nums
        int cur = nums.length - 2;
        while(cur >= 0){
            if(nums[cur] >= nums[cur+1]){
                cur--;
                continue;
            }
            if(nums[cur] < nums[cur+1]){
                break;
            }
        }
        
        // if no such an arrangement, reverse nums
        if(cur == -1){
            reverser(nums, 0);   
        }         
        else{
            int swp = nums.length - 1;
            while(nums[swp] <= nums[cur]){
                swp--;
            }
            swap(nums, swp, cur);
            reverser(nums, cur+1);
        }
    }
    
    // swap two elements in the list with O(1) space
    private void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    // reverse only the sublist after the index = pointer
    private void reverser(int[] num, int left){
        int right = num.length - 1;
        while(left < right){
            swap(num, left, right);
            left++;
            right--;
        }
    }
}
        
        
            
            