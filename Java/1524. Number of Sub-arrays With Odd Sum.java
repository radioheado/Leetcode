class Solution {
    public int numOfSubarrays(int[] arr) {
        int MODULO = (int)Math.pow(10, 9) + 7;
        int even = 1, odd = 0, prefix = 0, ans = 0;

        for (int num: arr) {
            prefix += num;
            if (prefix % 2 == 1) {
                ans = (ans + even) % MODULO;
                odd++;
            } else {
                ans = (ans + odd) % MODULO;
                even++;
            }
        }

        return ans;
    }
}