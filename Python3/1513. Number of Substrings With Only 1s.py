class Solution {
    public int numSub(String s) {
        int ans = 0, MOD = 100_000_000_7, streak = 0;
        for (char c: s.toCharArray()) {
            if (c == '1') {
                streak++;
            } else {
                streak = 0;
            }
            ans = (ans + streak) % MOD;
        }
        return ans;
    }
}