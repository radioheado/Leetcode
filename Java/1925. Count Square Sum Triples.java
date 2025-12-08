class Solution {
    public int countTriples(int n) {
        int ans = 0;
        for (int a = 1; a < n - 1; a++) {
            for (int b = a; b < n; b++) {
                double c = Math.sqrt(a * a + b * b);
                if (c == (int)c && c <= n) {
                    ans++;
                    if (a != b) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}