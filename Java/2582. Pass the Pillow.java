class Solution {
    public int passThePillow(int n, int time) {
        int m = time % (2 * n - 2);
        if (m >= n) {
            m -= n - 1;
            return n - m;
        } else{
            return m + 1;
        }
    }
}