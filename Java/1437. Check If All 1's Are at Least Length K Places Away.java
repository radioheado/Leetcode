class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (pre == -1 || i - pre > k) {
                    pre = i;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}