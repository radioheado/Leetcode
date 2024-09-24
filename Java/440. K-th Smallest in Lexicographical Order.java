class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = countSteps(n, cur, cur + 1);
            if (steps <= k) {
                cur++;
                k -= steps;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    private int countSteps(int n, long p1, long p2) {
        int steps = 0;
        while (p1 <= n) {
            steps += Math.min(n + 1, p2) - p1;
            p1 *= 10;
            p2 *= 10;
        }   
        return steps;
    }
}