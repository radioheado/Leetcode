class Solution {
    int missing (int i, int[] nums) {
        return nums[i] - nums[0] - i;
    }
    
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if (k > missing(n-1, nums)) {
            return nums[n-1] + k - missing(n-1, nums);
        }
        
        int left = 0, right = n-1, mid;
        while (left < right) {
            mid = (right-left)/2 + left;
            if (missing(mid, nums) < k) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        
        return nums[left-1] + k - missing(left-1, nums);
    }
}