class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int N = nums.length;
        int[] head_idx = new int[N];

        for (int i = 1; i < N; i++) {
            if (nums[i] % 2 + nums[i - 1] % 2 == 1) {
                head_idx[i] = head_idx[i - 1]; 
            } else {
                head_idx[i] = i;
            }
        }

        boolean[] ans = new boolean[queries.length];
        int i = 0;
        for (int[] query: queries) {
            ans[i++] = head_idx[query[1]] <= query[0];
        }

        return ans;
    }
}