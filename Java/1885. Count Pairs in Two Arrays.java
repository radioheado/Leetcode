class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        // rewrite as (nums1[i] - nums2[i]) + (nums1[j] - nums2[j]) > 0
        int N = nums1.length;
        int[] diff = new int[N];

        for (int i = 0; i < N; i++) {
            diff[i] = nums1[i] - nums2[i];
        }

        Arrays.sort(diff);
        int l = 0, r = N - 1;
        long ans = 0;
        while (l < r) {
            if (diff[l] + diff[r] > 0) {
                ans += r - l;
                r--;
            } else {
                l++;
            }
        }

        return ans;
    }
}