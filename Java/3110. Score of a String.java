class Solution {
    public int scoreOfString(String s) {
        int pre = s.charAt(0), ans = 0;
        for (int i = 1; i < s.length(); i++) {
            ans += Math.abs(s.charAt(i) - pre);
            pre = s.charAt(i);
        }
        return ans;
    }
}