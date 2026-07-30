class Solution {
    public int minimumPushes(String word) {
        int ans = 0, L = word.length(), base = 1;
        while (L > 0) {
            ans += base * Math.min(L, 8);
            L -= 8;
            base++;
        }
        return ans;
    }
}