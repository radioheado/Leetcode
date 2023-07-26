class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1, m;
        while (l < r) {
            m = (r - l) / 2 + l;
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}