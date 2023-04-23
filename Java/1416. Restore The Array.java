class Solution {
    private int[] dp;
    private int m, mod = (int)Math.pow(10, 9) + 7;

    public int numberOfArrays(String s, int k) {
        m = s.length();
        dp = new int[m + 1];
        return dfs(0, s, k) % mod;
    }

    private int dfs(int start, String s, int k) {
        if (dp[start] > 0) {
            return dp[start];
        }

        if (start == m) {
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        int count = 0;
        for (int end=start; end<m; end++) {
            Long cur = Long.parseLong(s.substring(start, end+1));
            if (cur > k) {
                break;
            }
            count =(count + dfs(end + 1, s, k)) % mod;
        }
        dp[start] = count;
        return count;
    }
}