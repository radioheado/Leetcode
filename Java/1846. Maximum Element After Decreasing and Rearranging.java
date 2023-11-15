class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length, ans = 1;
        int[] count = new int[n + 1];
        for (int num: arr) {
            count[Math.min(num, n)]++;
        }

        for (int i = 2; i <= n; i++) {
            ans = Math.min(ans + count[i], i);
        }

        return ans;
    }
}