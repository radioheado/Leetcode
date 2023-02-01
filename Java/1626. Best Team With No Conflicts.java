class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int N = ages.length;
        int[][] age_score = new int[N][2];
        for (int i = 0; i < N; i++) {
            age_score[i][0] = ages[i];
            age_score[i][1] = scores[i];
        }

        Arrays.sort(age_score, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return helper(age_score);
    }

    private int helper(int[][] age_score) {
        int N = age_score.length, ans = 0;
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = age_score[i][1];
            ans = Math.max(ans, dp[i]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (age_score[i][1] >= age_score[j][1]) {
                    dp[i] = Math.max(dp[i], age_score[i][1] + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}