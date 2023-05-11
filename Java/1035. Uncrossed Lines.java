class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] pre = new int[n + 1];
        int[] cur = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    cur[j] = Math.max(cur[j], pre[j-1] + 1);
                } else {
                    cur[j] = Math.max(cur[j-1], pre[j]);
                }
            }
            pre = cur.clone();
        }

        return cur[n];
    }
}