class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if ((start - i >= 0) && (nums[start - i] == target)) {
                return i;
            }
            if ((start + i < N) && (nums[start + i] == target)) {
                return i;
            }
        }
        return 0;
    }
}