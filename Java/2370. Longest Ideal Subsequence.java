class Solution {
    public int longestIdealString(String s, int k) {
        int ans = 0;
        int[] dp = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int best = 0, c = s.charAt(i) - 'a';
            for (int p = 0; p < 26; p++) {
                if (Math.abs(p - c) <= k) {
                    best = Math.max(best, dp[p]);
                }
            }
            dp[c] = Math.max(dp[c], best + 1);
            ans = Math.max(ans, dp[c]);
        }
        return ans;
    }
}