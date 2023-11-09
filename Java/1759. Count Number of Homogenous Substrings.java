class Solution {
    public int countHomogenous(String s) {
        int MOD = (int) Math.pow(10, 9) + 7, ans = 0, streak = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                streak++;
            } else {
                streak = 1;
            }
            ans = (ans + streak) % MOD;
        }

        return ans;
    }
}