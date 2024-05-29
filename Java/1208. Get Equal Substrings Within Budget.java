class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0, ans = 0, cost = 0;
        for (int r = 0; r < s.length(); r++) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}