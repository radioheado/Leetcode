class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i-1];
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] q: queries) {
            if (q[0] > 0) {
                ans[i++] = arr[q[0] - 1] ^ arr[q[1]];
            } else {
                ans[i++] = arr[q[1]];
            }
        }
        return ans;
    }
}