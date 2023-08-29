class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;

        for (int[] p: pairs) {
            if (p[0] > cur) {
                ans++;
                cur = p[1];
            }
        }

        return ans;
    }
}