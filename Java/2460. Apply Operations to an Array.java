class Solution {
    public int[] applyOperations(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) {
                int nxt_p = i + 1;
                while (nxt_p < N && nums[nxt_p] == 0) {
                    nxt_p++;
                }

                if (nxt_p < N) {
                    nums[i] = nums[nxt_p];
                    nums[nxt_p] = 0;
                }
            }
        }

        return nums;
    }
}