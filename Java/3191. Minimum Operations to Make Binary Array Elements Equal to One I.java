class Solution {
    public int minOperations(int[] nums) {
        int N = nums.length, ans = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) {
                if (i >= N - 2) {
                    return -1;
                }
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ans++;
            }
        }
        return ans;
    }
}