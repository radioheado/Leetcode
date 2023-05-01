class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = 0;
        while (l < r) {
            m = (r - l) / 2 + l;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        r = nums.length;
        return (l + r/2) < r && nums[l + r/2] == target;
    }
}