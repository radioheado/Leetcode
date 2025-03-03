class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i1 = 0, i2 = 0;
        List<int[]> ans = new ArrayList<>();

        while (i1 < nums1.length && i2 < nums2.length) {
            int[] n1 = nums1[i1], n2 = nums2[i2];
            if (n1[0] < n2[0]) {
                ans.add(n1);
                i1++;
            } else if (n1[0] > n2[0]) {
                ans.add(n2);
                i2++;
            } else {
                n1[1] += n2[1];
                ans.add(n1);
                i1++;
                i2++;
            }
        }

        while (i1 < nums1.length) {
            ans.add(nums1[i1]);
            i1++;
        }

        while (i2 < nums2.length) {
            ans.add(nums2[i2]);
            i2++;
        }

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}