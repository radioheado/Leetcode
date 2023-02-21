class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, m;

        while (l < r) {
            m = (r - l) / 2 + l;
            boolean even = (r - m) % 2 == 0;
            if (nums[m + 1] == nums[m]) {
                if (even) {
                    l = m + 2;
                } else {
                    r = m - 1;
                }
            } else if (nums[m - 1] == nums[m]) {
                if (even) {
                    r = m - 2;
                } else {
                    l = m + 1;
                }
            } else {
                return nums[m];
            }
        } 

        return nums[l];
    }
}