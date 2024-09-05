class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, total = (m + n) * mean;
        for (int r: rolls) {
            total -= r;
        }

        if (total < n || total > 6 * n) {
            return new int[0];
        }

        int[] ans = new int[n];
        int new_mean = total / n, mod = total % n;
        Arrays.fill(ans, new_mean);
        for (int i = 0; i < mod; i++) {
            ans[i]++;
        }
        return ans;
    }
}