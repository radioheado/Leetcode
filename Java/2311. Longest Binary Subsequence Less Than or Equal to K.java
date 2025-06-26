class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0, num = 0, base = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                ans++;
                base++;
            } else {
                if (num + Math.pow(2, base) <= k) {
                    ans++;
                    num += Math.pow(2, base);
                    base++;
                }
            }
        }

        return ans;
    }
}