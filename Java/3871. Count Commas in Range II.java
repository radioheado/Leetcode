class Solution {
    public long countCommas(long n) {
        long bound = 1000, ans = 0;
        while (bound <= n) {
            ans += n - bound + 1;
            bound *= 1000;
        }
        return ans;
    }
}