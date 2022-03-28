class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (right-left)/2 + left;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right--;
                } else {
                    left++;
                }
            } else if (nums[mid] <= nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}