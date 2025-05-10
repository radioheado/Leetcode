class Solution {
    public int[] buildArray(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }

        for (int i = 0; i < N; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }
}