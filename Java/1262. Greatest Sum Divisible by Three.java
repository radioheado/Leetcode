class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        dp[1] = Integer.MIN_VALUE;
        dp[2] = Integer.MIN_VALUE;

        for (int n: nums) {
            int[] tmp = Arrays.copyOf(dp, 3);
            for (int i = 0; i < 3; i++) {
                int j = (i + n % 3) % 3;
                tmp[j] = Math.max(tmp[j], dp[i] + n);
            }
            dp = tmp;
        }

        return dp[0];
    }
}