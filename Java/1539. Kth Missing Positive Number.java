class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1, m;

        while (l <= r) {
            m = (r - l)/2 + l;
            if (arr[m] - m - 1 < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l + k;
    }
}