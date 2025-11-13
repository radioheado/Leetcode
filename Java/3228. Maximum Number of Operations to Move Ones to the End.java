class Solution {
    public int maxOperations(String s) {
        int i = 0, ans = 0, streak = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                streak++;
                i++;
            } else {
                while (i < s.length() && s.charAt(i) == '0') {
                    i++;
                }
                ans += streak;
            }
        }
        return ans;
    }
}