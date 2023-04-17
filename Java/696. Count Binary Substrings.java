class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, ans = 0;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                ans += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(pre, cur);
    }
}